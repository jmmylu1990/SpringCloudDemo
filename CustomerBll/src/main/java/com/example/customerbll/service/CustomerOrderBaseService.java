package com.example.customerbll.service;

import com.example.customerbll.model.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("customer-order-base")
public interface CustomerOrderBaseService {

    @RequestMapping(value="/Customer/findAll", method=RequestMethod.GET)
    List<CustomerDTO> findAll();



}
