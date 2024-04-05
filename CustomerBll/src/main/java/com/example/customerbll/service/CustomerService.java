package com.example.customerbll.service;

import com.example.customerbll.model.dto.CustomerDTO;
import com.example.customerbll.model.dto.ResultDTO;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface CustomerService {
    ResultDTO<List<CustomerDTO>> findAll() throws TimeoutException;

    ResultDTO<List<CustomerDTO>>  findAll2() throws TimeoutException;

    ResultDTO<List<CustomerDTO>>  findAll3();

    ResultDTO<List<CustomerDTO>>  findAll4();
}
