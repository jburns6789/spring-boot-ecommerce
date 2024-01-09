package com.luv2code.ecommerce.Service;

import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.entity.Order;

public interface OrderService {
        // public List<Order> findAll();

        public Order findByOrderTrackingNumber(String theOrderTrackingNumber);

        public void update (Order theOrder);

        public void deleteByOrderTrackingNumber(String theOrderTrackingNumber);


    }


