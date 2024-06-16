package com.kfccoupon.pd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfccoupon.pd2.model.CouponMeal;
import com.kfccoupon.pd2.service.CrawlerService;

@RestController
public class MainController {

    @Autowired
    CrawlerService crawlerService;

    @GetMapping("/scrape")
    public ResponseEntity<List<CouponMeal>> scrapeData() {
        List<CouponMeal> data = crawlerService.scrapeAndSaveData();
        return ResponseEntity.ok(data);
    }
}
