package com.example.customerbll.service.impl;

import com.example.customerbll.model.dto.CustomerDTO;
import com.example.customerbll.service.CustomerOrderBaseService;
import com.example.customerbll.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerService customerService;

    //todo:這邊的事物管理未來會使用Seata的@GlobalTransactional
    @Override
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }
}
