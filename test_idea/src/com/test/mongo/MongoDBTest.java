package com.test.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.test.mongo.util.MongoDBJDBC;
import org.bson.Document;

public class MongoDBTest {

    public static void main(String[] args) {
        System.out.println("连接mongoDB");
        MongoDatabase mongoDatabase = MongoDBJDBC.getMongoDatabase("test");
        System.out.println(mongoDatabase.getName());
        MongoCollection<Document> collection = MongoDBJDBC.getCollection(mongoDatabase,"test");
        System.out.println(collection.count());
        Document document = new Document("title", "MongoDB");
        document.append("x",10);
        document.append("y",10.12);
//        MongoDBJDBC.insertOne(mongoDatabase,"test",document);
        MongoDBJDBC.removeOne(mongoDatabase,"test", Filters.eq("title","MongoDB"));
        MongoCursor<Document> mongoCursor = MongoDBJDBC.find(mongoDatabase,"test");
        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
        System.out.println("连接mongoDB成功");
    }
}
