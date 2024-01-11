package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.Service.OrderService;
import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.dto.OrderDto;
import com.luv2code.ecommerce.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(value = "${allowed.origins}", maxAge = 3600)
@RequestMapping("/api/orders/")
public class OrderManipulationController {

//    private OrderService orderService;

//    public OrderManipulationController(OrderService orderService) {this.orderService = orderService;}

    @Autowired
    private OrderRepository orderRepository;

    @PutMapping(value = "updateOrder/{orderTrackingNumber}") //put vs patch?
    public ResponseEntity<OrderDto> updateOrder(@PathVariable String orderTrackingNumber, @RequestParam("quantity") Integer totalQuantity) {
        Optional<Order> optionalOrder = orderRepository.findByOrderTrackingNumber(orderTrackingNumber);

        if(!optionalOrder.isPresent()){
            return ResponseEntity.notFound().build();
        }


        else {
            Order order = optionalOrder.get();
            System.out.println("Order details ==>" + order);


            order.setTotalQuantity(totalQuantity);
            orderRepository.save(order);

            OrderDto orderDto = new OrderDto(order.getOrderTrackingNumber(), order.getTotalQuantity());

            System.out.println("Order Dto tracking number ==>" + order.getOrderTrackingNumber());

            return ResponseEntity.ok(orderDto);
        }
    }

    @DeleteMapping("deleteOrder/{orderTrackingNumber}")//tracking number? order?
    public ResponseEntity<String> deleteOrder(@PathVariable String orderTrackingNumber) {
        Optional<Order> optionalOrder = orderRepository.findByOrderTrackingNumber(orderTrackingNumber);
        if(!optionalOrder.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Order order = optionalOrder.get();


        orderRepository.deleteById(order.getId());

        // {message: ""}

        return ResponseEntity.ok("{\"message\": \"Order deleted successfully\"}");
    }
}
