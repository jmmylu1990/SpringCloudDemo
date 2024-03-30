package com.example.customerorderbase.service;

import com.example.customerorderbase.mysql.entity.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {
    List<Customer> findAll();
}
