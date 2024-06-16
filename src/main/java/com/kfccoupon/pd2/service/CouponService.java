package com.kfccoupon.pd2.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfccoupon.pd2.dao.CouponDao;
import com.kfccoupon.pd2.dto.CouponMealDto;
import com.kfccoupon.pd2.model.CouponMeal;

@Service
public class CouponService {

    @Autowired
    private CouponDao couponDao;

    public void scrapeAndSaveData() {
        List<CouponMealDto> mealDtos = new ArrayList<>();
        try {
            List<String> meal_urls_and_imgs = Crawler.setup_meal_url();
            Map<String, CouponMealDto> map = new HashMap<>();

            // produce all meal instances
            for (String meal_url_img : meal_urls_and_imgs) {
                String[] url = meal_url_img.split(",");
                CouponMealDto mealDto = Crawler.setupMeal(url[0], url[1]);
                mealDtos.add(mealDto);

                map.put(mealDto.getCode(), mealDto);
            }

            Crawler.setupContents(map);

            for (CouponMealDto dto : mealDtos) {
                CouponMeal meal = convertToEntity(dto);
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
    }

    private CouponMeal convertToEntity(CouponMealDto mealDto) {
        CouponMeal meal = new CouponMeal();

        meal.setCode(mealDto.getCode());
        meal.setImgUrl(mealDto.getImgUrl());
        meal.setPrice(mealDto.getPrice());
        meal.setContent(mealDto.getContent());

        return meal;
    }

    public List<CouponMealDto> getData() {
        List<CouponMeal> meals = couponDao.findAll();
        List<CouponMealDto> dtos = new ArrayList<>();
        for (CouponMeal meal : meals) {
            CouponMealDto dto = new CouponMealDto();
            dto.setCode(meal.getCode());
            dto.setPrice(meal.getPrice());
            dto.setImgUrl(meal.getImgUrl());
            dto.setContent(meal.getContent(), false);
            dtos.add(dto);
        }
        return dtos;
    }

    public List<CouponMealDto> sortByPrice(boolean mode) {
        List<CouponMealDto> dtos = getData();
        if (mode) {
            dtos.sort(Comparator.comparingInt(CouponMealDto::getPrice));
        } else {
            dtos.sort((a, b) -> b.getPrice() - a.getPrice());
        }
        return dtos;
    }

    public List<CouponMealDto> filterNuggets() {
        List<CouponMealDto> meals = getData();

        List<CouponMealDto> result = new ArrayList<>();
        for (CouponMealDto dto : meals) {
            String tmp = dto.getContent();
            if (tmp.contains("J")) {
                result.add(dto);
            }
        }

        result.sort(Comparator.comparingInt(CouponMealDto::getPrice));

        return result;
    }

    public List<CouponMealDto> filterTart() {
        List<CouponMealDto> meals = getData();

        List<CouponMealDto> result = new ArrayList<>();
        for (CouponMealDto dto : meals) {
            String tmp = dto.getContent();
            if (tmp.contains("D")) {
                result.add(dto);
            }
        }

        result.sort(Comparator.comparingInt(CouponMealDto::getPrice));

        return result;
    }

    public List<CouponMealDto> filterQQ() {
        List<CouponMealDto> meals = getData();

        List<CouponMealDto> result = new ArrayList<>();
        for (CouponMealDto dto : meals) {
            String tmp = dto.getContent();
            if (tmp.contains("Q")) {
                result.add(dto);
            }
        }

        result.sort(Comparator.comparingInt(CouponMealDto::getPrice));

        return result;
    }

    public List<CouponMealDto> filterChiken() {
        List<CouponMealDto> meals = getData();

        List<CouponMealDto> result = new ArrayList<>();
        for (CouponMealDto dto : meals) {
            String tmp = dto.getContent();
            if (tmp.contains("C")) {
                result.add(dto);
            }
        }

        result.sort(Comparator.comparingInt(CouponMealDto::getPrice));

        return result;
    }

    public List<CouponMealDto> filterDaifuku() {
        List<CouponMealDto> meals = getData();

        List<CouponMealDto> result = new ArrayList<>();
        for (CouponMealDto dto : meals) {
            String tmp = dto.getContent();
            if (tmp.contains("F")) {
                result.add(dto);
            }
        }

        result.sort(Comparator.comparingInt(CouponMealDto::getPrice));

        return result;
    }
}
