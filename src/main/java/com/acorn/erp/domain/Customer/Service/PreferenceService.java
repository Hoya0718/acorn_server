package com.acorn.erp.domain.Customer.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
import com.acorn.erp.domain.Customer.Entity.GenderGroup;
import com.acorn.erp.domain.Customer.Entity.RegionGroup;
import com.acorn.erp.domain.Customer.Repository.AgeGroupRepository;
import com.acorn.erp.domain.Customer.Repository.GenderGroupRepository;
import com.acorn.erp.domain.Customer.Repository.PreferenceRepository;
import com.acorn.erp.domain.Customer.Repository.RegionGroupRepository;
import com.acorn.erp.domain.Sales.OrderRepository;
import com.acorn.erp.domain.Sales.OrderTable;

import jakarta.annotation.PostConstruct;

@Service
public class PreferenceService {
	private static final Logger logger = LoggerFactory.getLogger(PreferenceService.class);

	@Autowired
	private OrderRepository orderRepository; 
	@Autowired
	private GenderGroupRepository genderGroupRepository; 
	@Autowired
	private AgeGroupRepository ageGroupRepository; 
	@Autowired
	private RegionGroupRepository regionGroupRepository; //
	@Autowired
	private PreferenceRepository repository;

	@Transactional
	@PostConstruct
	public void calculateOrderData() {

//		logger.info("calculateOrderData() 실행 시작");

		List<OrderTable> completedOrders = orderRepository.findAll().stream()
				.filter(order -> "Delivered".equals(order.getOrderStatus())).collect(Collectors.toList());

//		logger.info("완료된 주문 수: {}", completedOrders.size());

		// 제품 이름 목록 생성
		List<String> itemNames = completedOrders.stream().map(OrderTable::getItemName).distinct()
				.collect(Collectors.toList());

//		logger.info("고유한 제품 이름 수: {}", itemNames.size());

		// 각 제품 이름에 거래 총금액, 총수량, 평점 계산하기
		for (String itemName : itemNames) {
			List<OrderTable> ordersForItem = orderRepository.findAll().stream()
					.filter(order -> itemName.equals(order.getItemName())).collect(Collectors.toList());

			int totalAmount = ordersForItem.stream().mapToInt(order -> order.getPrice() * order.getItemQty()).sum();

			int totalQuantity = ordersForItem.stream().mapToInt(OrderTable::getItemQty).sum();

//			logger.info("Item: {}, Total Amount: {}, Total Quantity: {}", itemName, totalAmount, totalQuantity);

			// 평점 계산 (예시로 평점 필드를 가정)
//            double rating = ordersForItem.stream()
//                    .mapToDouble(OrderTable::getRating)
//                    .average()
//                    .orElse(0.0);

			// 선호도 계산
			Map<String, Long> genderCountMap = ordersForItem.stream()
                    .flatMap(order -> genderGroupRepository.findByCustomerId(order.getCustomerId()).stream())
                    .collect(Collectors.groupingBy(GenderGroup::getGenderGroup, Collectors.counting()));
					
	                
			String genderPreference = genderCountMap.entrySet().stream().max(Map.Entry.comparingByValue())
					.map(Map.Entry::getKey).orElse("Unknown");
			
			// 연령별 선호도 계산
			 Map<String, Long> ageCountMap = ordersForItem.stream()
	                    .flatMap(order -> ageGroupRepository.findByCustomerId(order.getCustomerId()).stream())
	                    .collect(Collectors.groupingBy(AgeGroup::getAgeGroup, Collectors.counting()));
				
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
		                .flatMap(order -> regionGroupRepository.findByCustomerId(order.getCustomerId()).stream())
		                .collect(Collectors.groupingBy(RegionGroup::getRegiongroupTown, Collectors.counting()));

		        String provincePreference = provinceCountMap.entrySet().stream().max(Map.Entry.comparingByValue())
		                .map(Map.Entry::getKey).orElse("Unknown");

		        String cityPreference = cityCountMap.entrySet().stream().max(Map.Entry.comparingByValue())
		                .map(Map.Entry::getKey).orElse("Unknown");

		        String townPreference = townCountMap.entrySet().stream().max(Map.Entry.comparingByValue())
		                .map(Map.Entry::getKey).orElse("Unknown");

		        String regionPreference = String.format("%s, %s, %s", provincePreference, cityPreference, townPreference);

//			logger.info("Gender Preference: {}, Age Preference: {}", genderPreference, agePreference);

			
			// CustomerPreferenceData 객체 생성 및 데이터 설정
			if (!repository.existsByItemName(itemName)) {
				// CustomerPreferenceData 객체 생성 및 데이터 설정
				CustomerPreferenceData data = new CustomerPreferenceData();
				data.setItemName(itemName);
				data.setTotalAmountForProduct(totalAmount);
				data.setTotalCountForProduct(totalQuantity);
				data.setGenderPreference(genderPreference);
				data.setAgePreference(agePreference);
				data.setRegionPreference(regionPreference);

				repository.save(data);
//				logger.info("Saved CustomerPreferenceData: {}", data);
			} else {
				logger.info("ProductName {} already exists. Skipping...", itemName);
			}
		}
	}

	public List<CustomerPreferenceData> getCustomerPreferences() {
		return repository.findAll();
	}
	 public List<CustomerPreferenceData> getTop3ByTotalAmount() {
	        return repository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "totalAmountForProduct"))).getContent();
	    }

	    public List<CustomerPreferenceData> getTop3ByTotalCount() {
	        return repository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "totalCountForProduct"))).getContent();
	    }

	    public List<CustomerPreferenceData> getTop3ByRating() {
	        return repository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "rating"))).getContent();
	    }
}
