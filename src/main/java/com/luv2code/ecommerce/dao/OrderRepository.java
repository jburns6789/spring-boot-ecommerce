package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);
    //spring will generate the query based on the method name: find by, customer email, order by, date created, descending

    Page<Order> findByOrderTrackingNumber(@Param("order_tracking_number") String orderTrackingNumber);

    void deleteByOrderTrackingNumber(String orderTrackingNumber);
    //find order by tracking number

}

