package com.luv2code.ecommerce.dto;

public class OrderDto {

    private String orderTrackingNumber;

    private int totalQuantity;

    public OrderDto(String trackingNumber, int quantity){
        this.orderTrackingNumber = trackingNumber;
        this.totalQuantity = quantity;
    }

    public String getOrderTrackingNumber(){
        return this.orderTrackingNumber;
    }

    public int getTotalQuantity(){
        return  this.totalQuantity;
    }


}
