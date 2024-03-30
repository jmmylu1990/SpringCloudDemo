package com.example.customerorderbase.mysql.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer_order")
public @Data class CustomerOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @Column(name = "productName")
    private String productName;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "orderDate")
    private Date orderDate;

}
