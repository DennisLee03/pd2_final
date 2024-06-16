package com.kfccoupon.pd2.service;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.kfccoupon.pd2.dto.CouponMealDto;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Crawler {
    // all coupons here
    public static final String KFC_COUPON_URL = "https://www.kfcclub.com.tw/Coupon";

    // to get images with their descriptions
    public static final String KFC_PARTIAL_COUPON_IMG_URL = "https://kfcoosfs.kfcclub.com.tw/";

    // it need fCode to direct to a specific meal
    public static final String KFC_PARTIAL_MEAL_URL = "https://www.kfcclub.com.tw/meal/";

    public static List<String> setup_meal_url() throws Exception {
        Document doc = Jsoup.connect(KFC_COUPON_URL).get();
        Elements scripts = doc.select("script");
        for (Element script : scripts) {
            String content = script.html().trim();

            int start_idx = content.indexOf("coupondata: [");
            if (start_idx != -1) {
                int end_idx = content.indexOf("]", start_idx) + 1;

                String jsonPart = content.substring(start_idx + "coupondata: ".length(), end_idx);

                Pattern p = Pattern
                        .compile("\"ImgNameNew\"\s*:\s*\"([^\"]+)\",[\\s\\n\\r]*\"Fcode\"\s*:\s*\"([^\"]+)\"");
                Matcher m = p.matcher(jsonPart);

                List<String> meals = new ArrayList<>();
                while (m.find()) {
                    String link = KFC_PARTIAL_MEAL_URL + m.group(2);
                    String img_url = KFC_PARTIAL_COUPON_IMG_URL + m.group(1);
                    meals.add(link + "," + img_url);
                }
                return meals;
            }
        }
        return null;
    }

    // data transfer
    public static CouponMealDto setupMeal(String url, String img_url) {
        CouponMealDto mealDto = new CouponMealDto();

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("fail to connect to coupon url.");
        }

        Element price = doc.selectFirst("span.small-price");
        String price_str = price.text().substring(1).replaceAll(",", "");
        mealDto.setPrice(Integer.parseInt(price_str));

        Element code = doc.selectFirst("h1.combo-flow__header-title.mealsTitle");
        mealDto.setCode(code.text().replaceAll("[^0-9]", ""));

        mealDto.setImgUrl(img_url);

        return mealDto;
    }

    public static void setupContents(Map<String, CouponMealDto> map) {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream("other/meals.csv"), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                String code = line.substring(0, 5);
                CouponMealDto m = map.get(code);
                if (m == null) {
                    continue;
                }
                m.setContent(line.substring(6, line.length()), true);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
