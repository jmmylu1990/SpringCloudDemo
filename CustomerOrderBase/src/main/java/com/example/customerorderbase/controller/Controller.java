package com.example.customerorderbase.controller;

import com.example.customerorderbase.dto.ResultDTO;
import com.example.customerorderbase.mysql.entity.Customer;
import com.example.customerorderbase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/customer/findAll")
    public ResultDTO<List<Customer>> findAll(){
        System.out.println("抓");
        ResultDTO<List<Customer>> resultDTO = new ResultDTO<>();
        try{
            List<Customer> list = customerService.findAll();
            if (!list.isEmpty()){
                resultDTO.setData(list);
                resultDTO.setSuccess(true);
                resultDTO.setMsg("");
                return resultDTO;
            }else {
                resultDTO.setData(list);
                resultDTO.setSuccess(false);
                resultDTO.setMsg("查無資料");
                return resultDTO;
            }
        }catch (Exception ex){
            resultDTO.setData(null);
            resultDTO.setSuccess(false);
            resultDTO.setMsg(ex.getMessage());
            return resultDTO;
        }

    }

    @GetMapping("/customer/findAll2")
    public ResultDTO<List<Customer>> findAll2() throws InterruptedException {
        System.out.println("抓");
        Thread.sleep(20000);
        ResultDTO<List<Customer>> resultDTO = new ResultDTO<>();
        try{
            List<Customer> list = customerService.findAll();
            if (!list.isEmpty()){
                resultDTO.setData(list);
                resultDTO.setSuccess(true);
                resultDTO.setMsg("");
                return resultDTO;
            }else {
                resultDTO.setData(list);
                resultDTO.setSuccess(false);
                resultDTO.setMsg("查無資料");
                return resultDTO;
            }
        }catch (Exception ex){
            resultDTO.setData(null);
            resultDTO.setSuccess(false);
            resultDTO.setMsg(ex.getMessage());
            return resultDTO;
        }
    }

    @GetMapping("/customer/findAll3")
    public ResultDTO<List<Customer>> findAll3() throws InterruptedException {
        System.out.println("抓");
        Thread.sleep(20000);
        ResultDTO<List<Customer>> resultDTO = new ResultDTO<>();
        try{
            List<Customer> list = customerService.findAll();
            if (!list.isEmpty()){
                resultDTO.setData(list);
                resultDTO.setSuccess(true);
                resultDTO.setMsg("");
                return resultDTO;
            }else {
                resultDTO.setData(list);
                resultDTO.setSuccess(false);
                resultDTO.setMsg("查無資料");
                return resultDTO;
            }
        }catch (Exception ex){
            resultDTO.setData(null);
            resultDTO.setSuccess(false);
            resultDTO.setMsg(ex.getMessage());
            return resultDTO;
        }
    }

    @GetMapping("/customer/findAll4")
    public ResultDTO<List<Customer>> findAll4() throws InterruptedException {
        System.out.println("抓");
        ResultDTO<List<Customer>> resultDTO = new ResultDTO<>();
        try{
            List<Customer> list = customerService.findAll();
            if (!list.isEmpty()){
                resultDTO.setData(list);
                resultDTO.setSuccess(true);
                resultDTO.setMsg("");
                return resultDTO;
            }else {
                resultDTO.setData(list);
                resultDTO.setSuccess(false);
                resultDTO.setMsg("查無資料");
                return resultDTO;
            }
        }catch (Exception ex){
            resultDTO.setData(null);
            resultDTO.setSuccess(false);
            resultDTO.setMsg(ex.getMessage());
            return resultDTO;
        }
    }
    @Transactional
    @GetMapping("/customer/save")
    public void save() throws InterruptedException {
         Customer customer = new Customer();
        customer.setName("AAA");
        customer.setEmail("AAA");
        Customer customer1 = customerService.save(customer);
        Thread.sleep(20000);



    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }
}
