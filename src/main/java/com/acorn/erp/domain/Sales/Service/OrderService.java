package com.acorn.erp.domain.Sales.Service;

import com.acorn.erp.domain.Sales.Entity.OrderTable;
import com.acorn.erp.domain.Sales.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Page<OrderTable> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public List<OrderTable> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderTable getOrderByOrderNum(Long orderNum) {
        return orderRepository.findById(orderNum).orElse(null);
    }

    public OrderTable addOrder(OrderTable orderTable) {
        return orderRepository.save(orderTable);
    }

    public OrderTable updateOrder(Long orderNum, OrderTable orderTable) {
        if (orderRepository.existsById(orderNum)) {
            orderTable.setOrderNum(orderNum);
            return orderRepository.save(orderTable);
        } else {
            throw new RuntimeException("Order not found with orderNum " + orderNum);
        }
    }

    public boolean deleteOrder(Long orderNum) {
        if (orderRepository.existsById(orderNum)) {
            orderRepository.deleteById(orderNum);
            return true;
        } else {
            return false;
        }
    }
}
