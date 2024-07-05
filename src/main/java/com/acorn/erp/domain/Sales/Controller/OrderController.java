
package com.acorn.erp.domain.Sales.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}

//package com.acorn.erp.domain.Sales.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.acorn.erp.domain.Sales.Service.OrderService;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrderController {
//    private final OrderService orderService;
//
//    @Autowired
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//}

