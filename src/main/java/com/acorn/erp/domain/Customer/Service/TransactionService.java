package com.acorn.erp.domain.Customer.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;
import com.acorn.erp.domain.Customer.Repository.TransactionRepository;

@Service
public class TransactionService {

 //판매정보필요
//    @Autowired
//    private OrderRepository orderRepository;

    @Autowired
    private TransactionRepository repository;
    
//고객거래정보 데이터 입력
    @Transactional
    public void calculateAndInsertCustomerTransactionInfo() {
//        List<String> customerIds = orderRepository.findAll().stream()
//                .map(orderRepository::getCustomer_id)
//                .distinct()
//                .collect(Collectors.toList()); //order_status
//
//        for (String customerId : customerIds) {
//            // 최근 거래일 계산
//            Date lastTransactionDate = orderRepository.findMaxOrder_dateByCustomerId(customerId);
//
//            // 총 거래 금액 계산
//            int totalAmountForCustomer = orderRepository.sumItem_total_priceByCustomerId(customerId);
//            // 최고 매출 상품명 계산
//            String topSellingProduct = orderRepository.findItem_nameByCustomerId(customerId);
//
//            // 총 거래 횟수 계산
//            int totalCountForCustomer = orderRepository.sumItem_numByCustomerId(customerId);
//            // 최다 거래 상품명 계산
//            String mostPurchasedProduct = orderRepository.findItem_nameByCustomerId(customerId);
//
//            CustomerTransactionInfo info = new CustomerTransactionInfo();
//            info.setTransactionInfoId("CTI_" + customerId);
//            info.setCustomerId(customerId);	//FK
//            info.setLastTransactionDate(lastTransactionDate);
//            info.setTotalAmountForCustomer(totalAmountForCustomer);
//            info.setTopSellingProduct(topSellingProduct);
//            info.setTotalCountForCustomer(totalCountForCustomer);
//            info.setMostPurchasedProduct(mostPurchasedProduct);
//
//            repository.save(info);
//        }
    }
    
    //테이블에 출력하기
    //고객랭킹
}
