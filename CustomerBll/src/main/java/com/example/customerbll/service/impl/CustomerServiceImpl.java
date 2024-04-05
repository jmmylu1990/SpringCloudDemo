package com.example.customerbll.service.impl;

import com.example.customerbll.model.dto.CustomerDTO;
import com.example.customerbll.service.CustomerOrderBaseService;
import com.example.customerbll.service.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerOrderBaseService customerOrderBaseService;

    //todo:這邊的事物管理未來會使用Seata的@GlobalTransactional
    @Override
    @CircuitBreaker(name = "customerService",fallbackMethod = "buildFallbackFindAll")
    public List<CustomerDTO> findAll() throws TimeoutException {
//        try {
            longRunRandomly();
           return customerOrderBaseService.findAll();
//        } catch (Exception e) {
//            log.error("系統異常");
//            return new ArrayList<>();
//        }
    }

    public List<CustomerDTO> buildFallbackFindAll(Throwable t){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(9999999L);
        customerDTO.setCustomerOrders(null);
        customerDTO.setName("9999999");
        customerDTO.setEmail("9999999");
        customerDTO.setPhone("9999999");
        List<CustomerDTO> list = new ArrayList<>();
        list.add(customerDTO);
        return list;
    }


    //模擬連線超時
    private static void longRunRandomly() throws TimeoutException {
        log.info("連線中");
        int max = 2;
        int min = 1;
        int randomNum = new Random().nextInt((max - min + 1) + min);
        log.info("randomNum:{}",randomNum);
        if (randomNum == 2) sleep();
    }

    private static void sleep() throws TimeoutException {
        try {
            log.info("Sleeping......ZZZ");
            Thread.sleep(5000);
            throw new TimeoutException();
        } catch (InterruptedException e1){
            log.error("錯誤訊息{}",e1.getMessage());
        }catch (TimeoutException e2) {
            log.error("錯誤訊息連線超時");
            throw new TimeoutException();
        }
    }
}
