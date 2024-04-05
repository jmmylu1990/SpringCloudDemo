package com.example.customerorderbase.service;

import com.example.customerorderbase.mysql.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer save(Customer customer);

}
