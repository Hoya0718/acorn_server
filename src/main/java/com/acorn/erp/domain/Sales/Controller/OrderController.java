package com.acorn.erp.domain.Sales.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Sales.Entity.OrderTable;
import com.acorn.erp.domain.Sales.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderTable> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderNum}")
    public OrderTable getOrderByOrderNum(@PathVariable("orderNum") Long orderNum) {
        return orderService.getOrderByOrderNum(orderNum);
    }

    @PostMapping
    public OrderTable addOrder(@RequestBody OrderTable order) {
        return orderService.addOrder(order);
    }

    @PutMapping("/{orderNum}")
    public ResponseEntity<OrderTable> updateOrder(@PathVariable("orderNum") Long orderNum, @RequestBody OrderTable order) {
        OrderTable updatedOrder = orderService.updateOrder(orderNum, order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{orderNum}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderNum") Long orderNum) {
        if (orderService.deleteOrder(orderNum)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
