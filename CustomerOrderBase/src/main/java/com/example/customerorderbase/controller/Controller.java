package com.example.customerorderbase.controller;

import com.example.customerorderbase.mysql.entity.Customer;
import com.example.customerorderbase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/customer/findAll")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @Transactional
    @GetMapping("/customer/save")
    public void save() throws InterruptedException {
         Customer customer = new Customer();
        customer.setName("AAA");
        customer.setEmail("AAA");
        Customer customer1 = customerService.save(customer);
        System.out.println("customer1:"+customer1.toString());
        System.out.println("輸入中");
        Thread.sleep(20000);



    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }
}
