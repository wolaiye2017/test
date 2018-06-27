package com.test.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoHelper {

    private static final String     DB_NAME          = "test";
    private static final String     SERVER_ADDRESS   = "192.168.0.188";
    private static final int        PORT            = 27017;

    public MongoHelper(){}

    public MongoClient getMongoClient( ){
        MongoClient mongoClient = null;
        try {
            // 连接到 mongodb 服务
            mongoClient = new MongoClient(SERVER_ADDRESS, PORT);
            System.out.println("Connect to mongodb successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoClient;
    }

    public MongoDatabase getMongoDataBase(MongoClient mongoClient) {
        MongoDatabase mongoDataBase = null;
        try {
            if (mongoClient != null) {
                // 连接到数据库
                mongoDataBase = mongoClient.getDatabase(DB_NAME);
                System.out.println("Connect to DataBase successfully");
            } else {
                throw new RuntimeException("MongoClient不能够为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoDataBase;
    }

    public void closeMongoClient(MongoDatabase mongoDataBase,MongoClient mongoClient ) {
        if (mongoDataBase != null) {
            mongoDataBase = null;
        }
        if (mongoClient != null) {
            mongoClient.close();
        }
        System.out.println("CloseMongoClient successfully");
    }
}
