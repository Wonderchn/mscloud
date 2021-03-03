package com.hongna.controller;


import com.hongna.entity.CommentResult;
import com.hongna.entity.payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class paymentController {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    com.hongna.Service.paymentService paymentService;
    @PostMapping("/create")
    public CommentResult create(@RequestBody payment payment){
        int count = paymentService.create(payment);
        if (count!=0){
            return new CommentResult(200,"插入成功",count);
        }
        else {
            return new CommentResult(444,"插入失败",count);
        }
    }
    @GetMapping("/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") long id){
        payment paymentId = paymentService.getPaymentById(id);
        if (paymentId !=null){
            return new CommentResult(200, "查询成功",paymentId);

        }else{
            return new CommentResult(444,"查询失败",paymentId);
        }
    }
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
