package com.kfccoupon.pd2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoDeleteCollection {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void dropCollection(String collectionName) {
        if (mongoTemplate.collectionExists(collectionName)) {
            mongoTemplate.dropCollection(collectionName);
            System.out.println("------");
            System.out.println("Collection " + collectionName + " has been dropped.");
            System.out.println("------");
        } else {
            System.out.println("------");
            System.out.println("Collection " + collectionName + " does not exist.");
            System.out.println("------");
        }
    }
}
