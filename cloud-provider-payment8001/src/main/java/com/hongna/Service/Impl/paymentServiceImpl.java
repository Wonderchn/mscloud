package com.hongna.Service.Impl;

import com.hongna.Service.paymentService;
import com.hongna.entity.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class paymentServiceImpl implements paymentService {
    @Autowired
    private com.hongna.Dao.paymentDao paymentDao;
    @Override
    public int create(payment payment) {
        int count = paymentDao.create(payment);
        return count;
    }

    @Override
    public payment getPaymentById(long id) {
        payment payment = paymentDao.getPaymentById(id);
        return payment;

    }
}
