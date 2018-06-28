package com.test.mongo.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.test.mongo.util.JsonStrToMap;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoDaoImpl implements MongoDao {
    @Override
    public Map<String, Object> queryByID(MongoDatabase db, String table, Object Id) throws Exception {
        MongoCollection<Document> collection = db.getCollection(table);
        BasicDBObject query = new BasicDBObject("_id", Id);

        //  DBObject接口和BasicDBObject对象：表示一个具体的记录，BasicDBObject实现了DBObject，是key-value的数据结构，用起来和HashMap是基本一致的。
        FindIterable<Document> iterable = collection.find(query);
        Map<String,Object> jsonStrToMap = null;
        MongoCursor<Document> cursor = iterable.iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            String jsonString = user.toJson();
            jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);//这里用到我自己写的方法,主要是包json字符串转换成map格式,为后面做准备,方法放在后面
        }
        return jsonStrToMap;
    }
    @Override
    public List<Map<String,Object>> queryByDoc(MongoDatabase db, String table, BasicDBObject doc) throws Exception{
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find(doc);
        /**
         * 1. 获取迭代器FindIterable<Document>
         * 2. 获取游标MongoCursor<Document>
         * 3. 通过游标遍历检索出的文档集合
         * */

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        MongoCursor<Document> cursor = iterable.iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            String jsonString = user.toJson();
            Map<String, Object> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
            list.add(jsonStrToMap);
        }
        return list;
    }
    @Override
    public List<Map<String,Object>> queryAll(MongoDatabase db, String table) throws Exception{
        MongoCollection<Document> collection = db.getCollection(table);
        FindIterable<Document> iterable = collection.find();

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        MongoCursor<Document> cursor = iterable.iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            String jsonString = user.toJson();
            Map<String, Object> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
            list.add(jsonStrToMap);
        }
        return list;
    }
    @Override
    public boolean insert(MongoDatabase db, String table, Document document) throws Exception {
        MongoCollection<Document> collection = db.getCollection(table);
        collection.insertOne(document);
        long count = collection.count(document);
        if(count == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean insertMany(MongoDatabase db, String table, List<Document> documents )throws Exception {
        MongoCollection<Document> collection = db.getCollection(table);
        long preCount = collection.count();
        collection.insertMany(documents);
        long nowCount = collection.count();
        if((nowCount-preCount) == documents.size() ){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public boolean delete(MongoDatabase db, String table, BasicDBObject document) throws Exception {
            MongoCollection<Document> collection = db.getCollection(table);
            DeleteResult deleteManyResult = collection.deleteMany(document);
            long deletedCount = deleteManyResult.getDeletedCount();
            if(deletedCount > 0){
                return true;
            }else{
                return false;
            }
    }

    @Override
    public boolean deleteOne(MongoDatabase db, String table, BasicDBObject document)throws Exception {
        MongoCollection<Document> collection = db.getCollection(table);
        DeleteResult deleteOneResult = collection.deleteOne(document);
        long deletedCount = deleteOneResult.getDeletedCount();
        if(deletedCount == 1){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public boolean update(MongoDatabase db, String table, BasicDBObject whereDoc, BasicDBObject updateDoc) throws Exception {
        MongoCollection<Document> collection = db.getCollection(table);
        UpdateResult updateManyResult = collection.updateMany(whereDoc, new Document("$set",updateDoc));
        long modifiedCount = updateManyResult.getModifiedCount();

        if (modifiedCount > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateOne(MongoDatabase db, String table, BasicDBObject whereDoc,BasicDBObject updateDoc) throws Exception {
        MongoCollection<Document> collection = db.getCollection(table);
        UpdateResult updateOneResult = collection.updateOne(whereDoc, new Document("$set",updateDoc));
        long modifiedCount = updateOneResult.getModifiedCount();
        if(modifiedCount == 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * create collection
     * @param db
     * @param table
     */
    public void createCol(MongoDatabase db, String table) {
        db.createCollection(table);
        System.out.println("集合创建成功");
    }

    /**
     * drop a collection
     * @param db
     * @param table
     */
    public void dropCol(MongoDatabase db, String table) {
        db.getCollection(table).drop();
        System.out.println("集合删除成功");

    }

}
