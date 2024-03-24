package com.example.customerorderbase.controller;

import com.example.customerorderbase.mysql.entity.Customer;
import com.example.customerorderbase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/Customer/findAll")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }
}
