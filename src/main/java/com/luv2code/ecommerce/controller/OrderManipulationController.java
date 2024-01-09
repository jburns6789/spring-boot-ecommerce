package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.Service.OrderService;
import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "${allowed.origins}", maxAge = 3600)
@RequestMapping("/api/orders/")
public class OrderManipulationController {

//    private OrderService orderService;

//    public OrderManipulationController(OrderService orderService) {this.orderService = orderService;}

    @Autowired
    private OrderRepository orderRepository;

    @PutMapping(value = "updateOrder/{orderTrackingNumber}") //put vs patch?
    public ResponseEntity<Order> updateOrder(@PathVariable String orderTrackingNumber, @RequestParam("quantity") Integer totalQuantity) {
        Order order = orderRepository.findByOrderTrackingNumber(orderTrackingNumber);
        order.setTotalQuantity(totalQuantity);
        orderRepository.save(order);

        return ResponseEntity.ok(order);
    }

    @DeleteMapping("deleteOrder/{orderTrackingNumber}")//tracking number? order?
    public ResponseEntity<String> deleteOrder(@PathVariable String orderTrackingNumber) {
        Order order = orderRepository.findByOrderTrackingNumber(orderTrackingNumber);
        orderRepository.deleteById(order.getId());

        return ResponseEntity.ok("Order deleted successfully");
    }
}
