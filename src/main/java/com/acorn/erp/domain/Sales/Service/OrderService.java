package com.acorn.erp.domain.Sales.Service;

import com.acorn.erp.domain.Sales.Entity.OrderTable;
import com.acorn.erp.domain.Sales.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderTable> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderTable getOrderByOrderNum(Long orderNum) {
        return orderRepository.findById(orderNum).orElse(null);
    }

    public OrderTable addOrder(OrderTable order) {
        return orderRepository.save(order);
    }

    public OrderTable updateOrder(Long orderNum, OrderTable order) {
        Optional<OrderTable> existingOrderOptional = orderRepository.findById(orderNum);
        if (existingOrderOptional.isPresent()) {
            OrderTable existingOrder = existingOrderOptional.get();
            existingOrder.setItemName(order.getItemName());
            existingOrder.setCustomerName(order.getCustomerName());
            existingOrder.setCustomerTel(order.getCustomerTel());
            existingOrder.setItemQty(order.getItemQty());
            existingOrder.setOrderPrice(order.getOrderPrice());
            existingOrder.setOrderDate(order.getOrderDate());
            existingOrder.setOrderStatus(order.getOrderStatus());
            existingOrder.calculateTotalPrice();
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    public boolean deleteOrder(Long orderNum) {
        if (orderRepository.existsById(orderNum)) {
            orderRepository.deleteById(orderNum);
            return true;
        }
        return false;
    }
}
