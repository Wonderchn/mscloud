package com.hongna.service;

import com.hongna.entity.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") long id);
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}

