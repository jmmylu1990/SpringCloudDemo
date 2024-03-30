package com.example.customerbll.service;

import com.example.customerbll.model.dto.CustomerDTO;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface CustomerService {
    List<CustomerDTO> findAll() throws TimeoutException;
}
