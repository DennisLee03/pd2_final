package com.kfccoupon.pd2.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CouponMealDto {

    @NotEmpty(message = "Code cannot be empty")
    private String code;

    @NotNull(message = "Price cannot be null")
    private Integer price;

    @NotEmpty(message = "Image URL cannot be empty")
    private String imgUrl;

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
