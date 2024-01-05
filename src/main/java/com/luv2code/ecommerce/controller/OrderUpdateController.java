package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.Service.OrderService;
import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.entity.Order;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequestMapping("/api/order/")
//@EnableWebMvc// required?
public class OrderUpdateController {

    private OrderRepository repository;

    OrderUpdateController(OrderRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/order/{orderTrackingNumber}") //put vs patch?
    public Order updateOrder(@RequestBody Order newOrder, @PathVariable String orderTrackingNumber) {
        // get the order and specify what needs to be modified
        //how to match based on tracking number?

        // update with values passed from angular

       //return //updated order to the db?

        //orderTrackingNumber=${guid}+"/update"+totalQuantity{quantity} angular call
/*
        return repository.findByOrderTrackingNumber(orderTrackingNumber)
                .map(order -> {
                    order.setTotalQuantity(orderTrackingNumber.quantity);
                    return repository.save(order)
                })
                 */
        return null;
    }



    @DeleteMapping("/order/{orderTrackingNumber}")//tracking number? order?
    public void deleteOrder(@PathVariable String orderTrackingNumber) {
        repository.deleteByOrderTrackingNumber(orderTrackingNumber);
    }


}
