package com.acorn.erp.domain.Customer.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Entity.CustomerTransactionInfo;
import com.acorn.erp.domain.Customer.Repository.TransactionRepository;
import com.acorn.erp.domain.Sales.Entity.OrderTable;
import com.acorn.erp.domain.Sales.Repository.OrderRepository;

import jakarta.annotation.PostConstruct;

@Service
public class TransactionService {

	@Autowired
	private OrderRepository orderRepository; 
    @Autowired
    private TransactionRepository repository;
    
//    @PostConstruct
//    @Transactional
//    public void init() {
//        calculateTransactionData();
//    }
    
    @Transactional
    public void calculateTransactionData(int customerId) {
		List<OrderTable> completedOrders = orderRepository.findAll().stream()
				.filter(order -> "Delivered".equals(order.getOrderStatus())).collect(Collectors.toList());

		List<Integer> customerIds = completedOrders.stream()
				.map(OrderTable::getCustomerId).distinct()
				.collect(Collectors.toList());
		
        	LocalDateTime lastTransactionDate = orderRepository.findTopByCustomerIdOrderByOrderDateDesc(customerId);
            // 이름 가져오기
            List<String> customerNames = orderRepository.findCustomerNameByCustomerId(customerId);
            String customerName = customerNames.isEmpty() ? null : customerNames.get(0);
            // 총 거래 금액 계산
            int totalAmountForCustomer = orderRepository.sumOrderTotalPriceByCustomerId(customerId);
            // 최고 매출 상품명 계산
            List<String> topSellingProducts = orderRepository.findFirstByCustomerIdOrderByTotalPriceDesc(customerId);
            String topSellingProduct = topSellingProducts.isEmpty() ? null : topSellingProducts.get(0);
            // 총 거래 횟수 계산
            int totalCountForCustomer = orderRepository.sumItemQtyByCustomerId(customerId);
            // 최다 거래 상품명 계산
            List<String> mostPurchasedProducts = orderRepository.findTopByCustomerIdOrderByItemQtyDesc(customerId);
            String mostPurchasedProduct = mostPurchasedProducts.isEmpty() ? null : mostPurchasedProducts.get(0);

			if (!repository.existsByCustomerId(customerId)) {
            CustomerTransactionInfo info = new CustomerTransactionInfo();
            
            info.setTransactionInfoId(customerId);
            info.setCustomerId(customerId);
            info.setCustomerName(customerName); 
            info.setLastTransactionDate(lastTransactionDate);
            info.setTotalAmountForCustomer(totalAmountForCustomer);
            info.setTopSellingProduct(topSellingProduct);
            info.setTotalCountForCustomer(totalCountForCustomer);
            info.setMostPurchasedProduct(mostPurchasedProduct);

            repository.save(info);
			
        }
    }
	public List<CustomerTransactionInfo> getCustomerRank() {
		return repository.findAll();
	}
	public List<CustomerTransactionInfo> getTop10ByTotalAmount() {
        List<CustomerTransactionInfo> allTransactions = repository.findAll();
        return allTransactions.stream()
                .sorted((t1, t2) -> Integer.compare(t2.getTotalAmountForCustomer(), t1.getTotalAmountForCustomer()))
                .limit(20)
                .collect(Collectors.toList());
    }

    public List<CustomerTransactionInfo> getTop10ByTotalCount() {
        List<CustomerTransactionInfo> allTransactions = repository.findAll();
        return allTransactions.stream()
                .sorted((t1, t2) -> Integer.compare(t2.getTotalCountForCustomer(), t1.getTotalCountForCustomer()))
                .limit(20)
                .collect(Collectors.toList());
    }
}
