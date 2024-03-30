package com.example.customerorderbase.service.impl;

import com.example.customerorderbase.mysql.entity.Customer;
import com.example.customerorderbase.mysql.repository.CustomerRepository;
import com.example.customerorderbase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
