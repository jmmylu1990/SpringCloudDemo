package com.example.customerbll.controller;

import com.example.customerbll.model.dto.CustomerDTO;
import com.example.customerbll.service.CustomerOrderBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private CustomerOrderBaseService customerOrderBaseService;

        private String url;

        @GetMapping("/Customer/findAll")
        public List<CustomerDTO> findAll() {
          return  customerOrderBaseService.findAll();
        }

    }

