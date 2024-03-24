package com.example.customerbll.service;

import com.example.customerbll.model.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();
}
