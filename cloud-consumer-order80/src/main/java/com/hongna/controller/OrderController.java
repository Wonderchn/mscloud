package com.hongna.controller;

import com.hongna.entity.CommentResult;
import com.hongna.entity.payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    private static final String URL = "http://cloud-payment-service";
    @Autowired

    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/create")
    public CommentResult<payment> create(@RequestBody payment payment){
        return restTemplate.postForObject(URL+"/payment/create", payment, CommentResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommentResult<payment> getPayment(@PathVariable("id")long id){
        return restTemplate.getForObject(URL+"/payment/get/"+id, CommentResult.class);
    }
    @GetMapping("/xixi")
    public String hello(){
        return "hello";
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }
}
