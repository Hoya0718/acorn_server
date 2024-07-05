package com.acorn.erp.domain.Sales.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Sales.Entity.OrderTable;
import com.acorn.erp.domain.Sales.Repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public List<OrderTable> getAllItems() {
        return orderRepository.findAll();
    }
}
