package com.example.customerbll.controller;

import com.example.customerbll.model.dto.CustomerDTO;
import com.example.customerbll.model.dto.ResultDTO;
import com.example.customerbll.service.CustomerOrderBaseService;
import com.example.customerbll.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
public class Controller {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private CustomerService customerService;

        private String url;

        @GetMapping("/customer/findAll")
        public ResultDTO<List<CustomerDTO>> findAll() throws TimeoutException {
          return  customerService.findAll();
        }

    @GetMapping("/customer/findAll2")
    public ResultDTO<List<CustomerDTO>> findAll2() throws TimeoutException {
        return  customerService.findAll2();
    }

    @GetMapping("/customer/findAll3")
    public ResultDTO<List<CustomerDTO>> findAll3() throws TimeoutException {
        return  customerService.findAll3();
    }

    @GetMapping("/customer/findAll4")
    public ResultDTO<List<CustomerDTO>> findAll4() throws InterruptedException {
        ResultDTO<List<CustomerDTO>> resultDTO = new ResultDTO<>();
        System.out.println(1);
        try {
            resultDTO = customerService.findAll4();
            System.out.println(2);
            if (!resultDTO.getData().isEmpty()) {
                resultDTO.setData(resultDTO.getData());
                resultDTO.setSuccess(true);
                resultDTO.setMsg("");
                return resultDTO;
            } else {
                resultDTO.setData(null);
                resultDTO.setSuccess(false);
                resultDTO.setMsg("查無資料");
                return resultDTO;
            }
        } catch (Exception ex) {
            resultDTO.setData(null);
            resultDTO.setSuccess(false);
            resultDTO.setMsg(ex.getMessage());
            return resultDTO;
        }
    }
    }

