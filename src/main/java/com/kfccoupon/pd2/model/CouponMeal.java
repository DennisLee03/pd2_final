package com.kfccoupon.pd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data // automatically generate setters, getters, toString()
@Document(collection = "meals")
public class CouponMeal {

    @Id // _id
    private String code;
    private Integer price;
    private String imgUrl;
    private String content;
}
