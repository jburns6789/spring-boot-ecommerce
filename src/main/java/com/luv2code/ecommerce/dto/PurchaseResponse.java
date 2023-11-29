package com.luv2code.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

    private final String orderTrackingNumber;
}

// use class to send back a Java object as JSON

//Lombok @data will generate constructor for final fields