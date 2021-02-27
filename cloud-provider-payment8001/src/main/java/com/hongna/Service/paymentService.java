package com.hongna.Service;


import com.hongna.entity.payment;

public interface paymentService {
    int create(payment payment);
    payment getPaymentById(long id);
}
