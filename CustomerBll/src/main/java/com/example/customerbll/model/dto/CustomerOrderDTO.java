package com.example.customerbll.model.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
public @Data class CustomerOrderDTO implements Serializable {
    private Long orderId;

    private CustomerDTO customer;
    private String productName;
    private Integer quantity;
    private Date orderDate;

}
