package com.example.customerbll.service.impl;

import com.example.customerbll.model.dto.CustomerDTO;
import com.example.customerbll.service.CustomerOrderBaseService;
import com.example.customerbll.service.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @CircuitBreaker(name = "customer-order-base")
//    @Retry(name = "findAllService")
    public List<CustomerDTO> findAll(){
        try {
            longRunRandomly();
        } catch (TimeoutException e) {
            log.error("系統異常");
//            throw new RuntimeException();
        }
        return customerOrderBaseService.findAll();
    }
    //模擬連線超時
    private static void longRunRandomly() throws TimeoutException {
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
        } catch (InterruptedException ex) {
            log.error(ex.getMessage());
        }

    }
}
