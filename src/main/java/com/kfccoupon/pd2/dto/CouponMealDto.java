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

    @NotEmpty(message = "Content cannot be empty")
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content, boolean mode) {
        StringBuilder sb = new StringBuilder();

        if (mode) {
            if (content.contains("蛋撻")) {
                sb.append("D");
            }

            if (content.contains("QQ")) {
                sb.append("Q");
            }

            if (content.contains("上校")) {
                sb.append("J");
            }

            if (content.contains("麻脆雞") || content.contains("啦脆雞")) {
                sb.append("C");
            }

            if (content.contains("大福")) {
                sb.append("F");
            }
            this.content = sb.toString();
        } else {
            this.content = content;
        }
    }
}
