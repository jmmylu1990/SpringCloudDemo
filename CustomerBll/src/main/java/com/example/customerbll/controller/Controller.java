package com.example.customerbll.controller;

import com.example.customerbll.model.dto.CustomerDTO;
import com.example.customerbll.service.CustomerOrderBaseService;
import com.example.customerbll.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
public class Controller {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private CustomerService customerService;

        private String url;

        @GetMapping("/customer/findAll")
        public List<CustomerDTO> findAll() throws TimeoutException {
          return  customerService.findAll();
        }

    }

