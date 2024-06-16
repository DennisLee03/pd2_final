package com.kfccoupon.pd2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfccoupon.pd2.dao.CouponDao;
import com.kfccoupon.pd2.dto.CouponMealDto;
import com.kfccoupon.pd2.model.CouponMeal;

@Service
public class CrawlerService {

    @Autowired
    private CouponDao couponDao;

    public List<CouponMealDto> scrapeAndSaveData() {
        List<CouponMealDto> mealDtos = new ArrayList<>();
        try {
            List<String> meal_urls_and_imgs = Crawler.setup_meal_url();

            // produce all meal instances
            for (String meal_url_img : meal_urls_and_imgs) {
                String[] url = meal_url_img.split(",");
                CouponMealDto mealDto = Crawler.setupMeal(url[0], url[1]);
                mealDtos.add(mealDto);
                CouponMeal meal = convertToEntity(mealDto);
                couponDao.save(meal);
            }

            System.out.println("------");
            System.out.println("finish scraping");
            System.out.println("------");

        } catch (Exception ioe) {
            System.out.println("------");
            ioe.printStackTrace();
            System.out.println("------");

        }
        return mealDtos;
    }

    private CouponMeal convertToEntity(CouponMealDto mealDto) {
        CouponMeal meal = new CouponMeal();

        meal.setCode(mealDto.getCode());
        meal.setImgUrl(mealDto.getImgUrl());
        meal.setPrice(mealDto.getPrice());

        return meal;
    }
}
