package com.test.mongo.util;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class MongoDBJDBC {
    private  static MongoClient mongoClient;

    /**
     * 连接到 mongodb 服务
     * @return
     */
    public static MongoClient getMongoClient(){
        try {
            if(mongoClient == null){
                mongoClient = new MongoClient( "192.168.0.188" , 27017 );
            }
            return mongoClient;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *连接到数据库
     * @param dataBaseName 数据库名
     * @return
     */
    public static MongoDatabase getMongoDatabase(String dataBaseName){
        try {
           if(mongoClient == null){
               mongoClient = getMongoClient();
           }
            MongoDatabase mongoDatabase = mongoClient.getDatabase(dataBaseName);
            return mongoDatabase;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *创建集合
     * @param mongoDatabase
     * @param name 集合名
     */
    public static void createCollection(MongoDatabase mongoDatabase,String name){
        try {
            mongoDatabase.createCollection(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取集合
     * @param mongoDatabase
     * @param name 集合名称
     * @return
     */
    public static MongoCollection<Document> getCollection(MongoDatabase mongoDatabase,String name){
        try{
            MongoCollection<Document> collection = mongoDatabase.getCollection(name);
            return collection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 插入文档
     * 1. 创建文档 org.bson.Document 参数为key-value的格式
     * 2. 创建文档集合List<Document>
     * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
     * @param mongoDatabase
     * @param collectionName
     * @param documents
     */
    public static void insertMany(MongoDatabase mongoDatabase,String collectionName,List<Document> documents){
        try{
            MongoCollection<Document> collection = getCollection(mongoDatabase,collectionName);
            collection.insertMany(documents);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 插入文档
     * 1. 创建文档 org.bson.Document 参数为key-value的格式
     * 2. 创建文档集合List<Document>
     * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
     * @param mongoDatabase
     * @param collectionName
     * @param document
     */
    public static void insertOne(MongoDatabase mongoDatabase,String collectionName,Document document){
        try{
            MongoCollection<Document> collection = getCollection(mongoDatabase,collectionName);
            collection.insertOne(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 检索所有文档
     * 1. 获取迭代器FindIterable<Document>
     * 2. 获取游标MongoCursor<Document>
     * 3. 通过游标遍历检索出的文档集合
     * @param mongoDatabase
     * @param collectionName
     * @return
     */
    public static MongoCursor<Document> find(MongoDatabase mongoDatabase,String collectionName){
        try{
            MongoCollection<Document> collection = getCollection(mongoDatabase,collectionName);
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            return mongoCursor;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *删除一个
     * @param mongoDatabase
     * @param collectionName
     */
    public static void removeOne(MongoDatabase mongoDatabase, String collectionName, Bson wh){
        try{
            MongoCollection<Document> collection = getCollection(mongoDatabase,collectionName);
            collection.deleteOne(wh);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     *删除多个
     * @param mongoDatabase
     * @param collectionName
     * @param wh 条件
     */
    public static void removeAll(MongoDatabase mongoDatabase, String collectionName, Bson wh){
        try{
            MongoCollection<Document> collection = getCollection(mongoDatabase,collectionName);
            collection.deleteMany(wh);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
