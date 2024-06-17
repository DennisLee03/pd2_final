package com.kfccoupon.pd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfccoupon.pd2.dao.MongoDeleteCollection;
import com.kfccoupon.pd2.dto.CouponMealDto;
import com.kfccoupon.pd2.service.CouponService;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private CouponService couponService;

    @Autowired
    private MongoDeleteCollection mongoDeleteCollection;

    @PostMapping("/scrape")
    public ResponseEntity<String> scrapeData() {
        couponService.scrapeAndSaveData();
        return ResponseEntity.ok("重新爬蟲成功");
    }

    @GetMapping("/data")
    public ResponseEntity<List<CouponMealDto>> getData() {
        List<CouponMealDto> data = couponService.getData();
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCollection() {
        String collectionName = "meals";
        mongoDeleteCollection.dropCollection(collectionName);
        return ResponseEntity.ok("所有爬蟲數據已被刪除");
    }

    @GetMapping("/up_sort")
    public ResponseEntity<List<CouponMealDto>> getUpSortedData() {
        List<CouponMealDto> data = couponService.sortByPrice(true);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/down_sort")
    public ResponseEntity<List<CouponMealDto>> getDownSortedData() {
        List<CouponMealDto> data = couponService.sortByPrice(false);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/nuggets")
    public ResponseEntity<List<CouponMealDto>> getNuggetData() {
        List<CouponMealDto> data = couponService.filterNuggets();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/tarts")
    public ResponseEntity<List<CouponMealDto>> getTartData() {
        List<CouponMealDto> data = couponService.filterTart();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/qqs")
    public ResponseEntity<List<CouponMealDto>> getQQData() {
        List<CouponMealDto> data = couponService.filterQQ();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/chicken")
    public ResponseEntity<List<CouponMealDto>> getChickenData() {
        List<CouponMealDto> data = couponService.filterChiken();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/daifuku")
    public ResponseEntity<List<CouponMealDto>> getDaifukuData() {
        List<CouponMealDto> data = couponService.filterDaifuku();
        return ResponseEntity.ok(data);
    }
}
