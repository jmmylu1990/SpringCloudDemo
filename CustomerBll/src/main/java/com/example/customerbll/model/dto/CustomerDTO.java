package com.example.customerbll.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Set;

public @Data class CustomerDTO implements Serializable {

    private Long customerId;
    private String name;
    private String email;
    private String phone;
    private Set<CustomerOrderDTO> CustomerOrders;
}
