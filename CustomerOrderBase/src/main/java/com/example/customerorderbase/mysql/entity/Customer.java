package com.example.customerorderbase.mysql.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customer")
public @Data class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @EqualsAndHashCode.Exclude
    private Set<CustomerOrder> CustomerOrders;
}
