package com.kfccoupon.pd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfccoupon.pd2.dto.CouponMealDto;
import com.kfccoupon.pd2.service.CrawlerService;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    CrawlerService crawlerService;

    @GetMapping("/scrape")
    public ResponseEntity<List<CouponMealDto>> scrapeData() {
        List<CouponMealDto> data = crawlerService.scrapeAndSaveData();
        return ResponseEntity.ok(data);
    }
}
