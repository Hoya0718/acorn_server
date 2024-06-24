package com.acorn.erp.domain.Customer.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Entity.CustomerPreferenceData;
import com.acorn.erp.domain.Customer.Repository.PreferenceRepository;
//import com.acorn.erp.domain.Sales.Repository.OrderRepository;

@Service
public class PreferenceService {

//    @Autowired
//    private OrderRepository orderRepository;  //FK

    @Autowired
    private PreferenceRepository repository;

    @Transactional
    public void calculateAndInsertCustomerPreferenceData() {
//        List<String> productNames = orderRepository.findAll().stream()
//                .map(orderRepository::getProductId)
//                .distinct()
//                .collect(Collectors.toList()); //order_status가 판매완료인것만
//
//        for (String item_id : productNames) {
//            String ItemName = orderRepository.findById(item_id).orElseThrow().getItemName();
//            
//            // 총 거래 금액 계산
//            double totalAmountForProduct = orderRepository.sumItemTotalPriceByItem_id(item_id);
//
//            // 총 거래 횟수 계산
//            int totalCountForProduct = orderRepository.findItem_numByItem_id(item_id);
//
//            // 평점 계산 
//            double rating = orderRepository.averageRatingByItem_id(item_id);
//            
//            // 성별 선호도 계산
//            String genderPreference = orderRepository.findMaxCustomer_genderByItem_id(item_id);
//
//            // 연령별 선호도 계산
//            String agePreference = orderRepository.findMaxAgegroupByItem_id(item_id);
//
//            // 지역별 선호도 계산
//            String regionPreference = orderRepository.findMaxRegiongroup_provinceByItem_id(item_id);
//            //regiongroup_city
//            //regiongroup_town
//
//
//            CustomerPreferenceData data = new CustomerPreferenceData();
//            data.setPreferenceDataId(UUID.randomUUID().toString());
//            data.setProductName(productName);
//            data.setTotalAmountForProduct(totalAmountForProduct);
//            data.setTotalCountForProduct(totalCountForProduct);
//            data.setGenderPreference(genderPreference);
//            data.setAgePreference(agePreference);
//            data.setRegionPreference(regionPreference);
//            data.setRating(rating);
//
//            repository.save(data);
        }}
    
    //테이블에 출력하기
    //고객선호도: 최고매출상품, 최다거래상품, 반응좋은상품
    
