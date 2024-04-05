package com.example.customerbll.service;

import com.example.customerbll.model.dto.CustomerDTO;
import com.example.customerbll.model.dto.ResultDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@FeignClient("customer-order-base")
public interface CustomerOrderBaseService {

    @RequestMapping(value="/customer/findAll", method=RequestMethod.GET)
    ResultDTO<List<CustomerDTO>> findAll();

    @CircuitBreaker(name = "customerService", fallbackMethod = "fallbackMethod")
    @RequestMapping(value="/customer/findAll2", method=RequestMethod.GET)
    ResultDTO<List<CustomerDTO>> findAll2();

    @RequestMapping(value="/customer/findAll3", method=RequestMethod.GET)
    ResultDTO<List<CustomerDTO>> findAll3();

    @RequestMapping(value="/customer/findAll4", method=RequestMethod.GET)
    ResultDTO<List<CustomerDTO>> findAll4();


    default  ResultDTO<List<CustomerDTO>> fallbackMethod(Throwable throwable) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(9999999L);
        customerDTO.setCustomerOrders(null);
        customerDTO.setName("9999999");
        customerDTO.setEmail("9999999");
        customerDTO.setPhone("9999999");
        List<CustomerDTO> list = new ArrayList<>();
        list.add(customerDTO);
        ResultDTO<List<CustomerDTO>> resultDTO = new ResultDTO<>();
        resultDTO.setData(list);
        resultDTO.setSuccess(true);
        resultDTO.setMsg("熔斷處理2");

        return resultDTO;
    }

}



