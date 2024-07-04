package com.acorn.erp.domain.Customer.Service;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
import com.acorn.erp.domain.Customer.Entity.RegionGroup;
import com.acorn.erp.domain.Customer.Repository.AgeGroupRepository;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;
import com.acorn.erp.domain.Customer.Repository.GenderGroupRepository;
import com.acorn.erp.domain.Customer.Repository.PreferenceRepository;
import com.acorn.erp.domain.Customer.Repository.RegionGroupRepository;
import com.acorn.erp.domain.Sales.Entity.OrderTable;
import com.acorn.erp.domain.Sales.Repository.OrderRepository;

import jakarta.annotation.PostConstruct;

@Service
public class PreferenceService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private GenderGroupRepository genderGroupRepository;
	@Autowired
	private CustomerInfoRepository customerInfoRepository;
	@Autowired
	private AgeGroupRepository ageGroupRepository;
	@Autowired
	private RegionGroupRepository regionGroupRepository;
	@Autowired
	private PreferenceRepository repository;
	
	@Transactional
	public void calculateOrderData() {

		List<OrderTable> completedOrders = orderRepository.findAll().stream()
				.filter(order -> "Delivered".equals(order.getOrderStatus())).collect(Collectors.toList());

		// 제품 이름 목록 생성
		List<String> itemNames = completedOrders.stream().map(OrderTable::getItemName).distinct()
				.collect(Collectors.toList());

		// 각 제품 이름에 거래 총금액, 총수량 계산하기
		for (String itemName : itemNames) {
			List<OrderTable> ordersForItem = orderRepository.findAll().stream()
					.filter(order -> itemName.equals(order.getItemName())).collect(Collectors.toList());

			 BigDecimal  totalAmount = completedOrders.stream()
	                    .map(order -> order.getOrderPrice().multiply(BigDecimal.valueOf(order.getItemQty())))
	                    .reduce(BigDecimal.ZERO, BigDecimal::add);

			int totalQuantity = ordersForItem.stream().mapToInt(OrderTable::getItemQty).sum();
			
			// 성별 계산
			Map<String, Integer> genderTotalAmountMap = ordersForItem.stream()
                    .flatMap(order -> customerInfoRepository.findByCustomerId(order.getCustomerId()).stream()
                            .map(genderGroup -> new AbstractMap.SimpleEntry<>(genderGroup.getCustomerGender(),
                                    order.getOrderPrice().multiply(BigDecimal.valueOf(order.getItemQty())).intValue())))
                    .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));

			 String genderPreference = genderTotalAmountMap.entrySet().stream()
		                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("Unknown");

	            // 결과 출력
	            System.out.println("Item Name: " + itemName + ", Gender Preference: " + genderPreference);
			
			// 연령별 선호도 계산
	            Map<String, Integer> ageCountMap = ordersForItem.stream()
	            	    .flatMap(order -> ageGroupRepository.findByCustomerId(order.getCustomerId()).stream()
	            	        .map(ageGroup -> new AbstractMap.SimpleEntry<>(ageGroup.getAgeGroup(),
	            	            order.getOrderPrice().multiply(BigDecimal.valueOf(order.getItemQty())).intValue())))
	            	    .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));

			
			String agePreference = ageCountMap.entrySet().stream().max(Map.Entry.comparingByValue())
					.map(Map.Entry::getKey).orElse("Unknown");

			// 지역별 선호도 계산
			Map<String, Long> provinceCountMap = ordersForItem.stream()
					.flatMap(order -> regionGroupRepository.findByCustomerId(order.getCustomerId()).stream())
					.collect(Collectors.groupingBy(RegionGroup::getRegiongroupProvince, Collectors.counting()));

			Map<String, Long> cityCountMap = ordersForItem.stream()
					.flatMap(order -> regionGroupRepository.findByCustomerId(order.getCustomerId()).stream())
					.collect(Collectors.groupingBy(RegionGroup::getRegiongroupCity, Collectors.counting()));

			Map<String, Long> townCountMap = ordersForItem.stream()
					.flatMap(order -> regionGroupRepository.findByCustomerId(order.getCustomerId()).stream()
							.map(RegionGroup::getRegiongroupTown))
					.collect(Collectors.groupingBy(town -> town, Collectors.counting()));

			String regionPreference_province = provinceCountMap.entrySet().stream().max(Map.Entry.comparingByValue())
					.map(Map.Entry::getKey).orElse("Unknown");

			String regionPreference_city = cityCountMap.entrySet().stream().max(Map.Entry.comparingByValue())
					.map(Map.Entry::getKey).orElse("Unknown");

			String regionPreference_town = townCountMap.entrySet().stream().max(Map.Entry.comparingByValue())
					.map(Map.Entry::getKey).orElse("Unknown");

			// CustomerPreferenceData 객체 생성 및 데이터 설정
			if (!repository.existsByItemName(itemName)) {
				CustomerPreferenceData data = new CustomerPreferenceData();
				data.setItemName(itemName);
				data.setTotalAmountForProduct(totalAmount.intValue()); 
				data.setTotalCountForProduct(totalQuantity);
				data.setGenderPreference(genderPreference);
				data.setAgePreference(agePreference);
				data.setRegionPreference_province(regionPreference_province);
				data.setRegionPreference_city(regionPreference_city);
				data.setRegionPreference_town(regionPreference_town);

				repository.save(data);
				
			} else {
				System.out.println("ProductName {} already exists. Skipping..." + itemName);
			}
		}
	}
//	public List<Integer> getCustomerIds() {
//        return orderRepository.findAll().stream()
//                .map(OrderTable::getCustomerId)
//                .distinct()
//                .collect(Collectors.toList());
//    }
	public List<CustomerPreferenceData> getCustomerPreferences() {
		return repository.findAll();
	}

	public List<CustomerPreferenceData> getTop3ByTotalAmount() {
		return repository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "totalAmountForProduct")))
				.getContent();
	}

	public List<CustomerPreferenceData> getTop3ByTotalCount() {
		return repository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "totalCountForProduct")))
				.getContent();
	}

	public List<CustomerPreferenceData> getTop3ByRating() {
		return repository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "rating"))).getContent();
	}
}
