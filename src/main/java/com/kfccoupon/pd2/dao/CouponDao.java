package com.kfccoupon.pd2.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.kfccoupon.pd2.model.CouponMeal;

public interface CouponDao extends MongoRepository<CouponMeal, String> {
}
