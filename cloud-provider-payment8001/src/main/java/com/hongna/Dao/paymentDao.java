package com.hongna.Dao;


import com.hongna.entity.payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface paymentDao {
    int create(payment payment);
    payment getPaymentById(long id);
}
