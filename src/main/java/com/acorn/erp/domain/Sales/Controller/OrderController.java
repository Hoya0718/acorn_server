package com.acorn.erp.domain.Sales.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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

    // 紐⑤뱺 二쇰Ц??媛?몄삤??硫붿냼??
    @GetMapping
    public List<OrderTable> getAllOrders() {
        return orderService.getAllOrders();
    }

    // ?섏씠吏뺣꽕?댁뀡??吏?먰븯??硫붿냼??
    @GetMapping("/paged")
    public Page<OrderTable> getOrders(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "7") int size) {
			Pageable pageable = PageRequest.of(page, size, Sort.by("orderNum").descending());
			return orderService.getOrders(pageable);
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
