package com.example.customerclient.controller;

import com.example.customerclient.service.CallCustomerClient2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class Controller {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private CallCustomerClient2Service callCustomerClient2Service;

        private String url;

        @GetMapping("/load")
        public String load() {
            String load = callCustomerClient2Service.load();
          return load;
        }

        @GetMapping(value = "/hello")
        public String hello() {

            String hello = callCustomerClient2Service.hello();

            return hello;
        }
    }

