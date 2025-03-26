package com.zel92.udemy_java_course.enumeration;

import java.util.Arrays;

public enum OrderStatus {
    WAITING_PAYMENT("Waiting Payment"),
    PAID("Paid"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELED("Canceled");

    private String status;

    private OrderStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status; 
    }

    public static OrderStatus convertToEnum(String status){
        return Arrays.stream(OrderStatus.values()).filter(enumerated -> enumerated.equals(status)).findFirst().orElseThrow();
    }
}
