package com.example.customerclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("CUSTOMERCLIENT2")
public interface CallCustomerClient2Service {

    @RequestMapping(value="/load", method=RequestMethod.GET)
     String load();

    @RequestMapping(value="/hello", method= RequestMethod.GET)
     String hello();

}
