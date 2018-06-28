package com.test.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.test.mongo.dao.MongoDao;
import com.test.mongo.dao.MongoDaoImpl;
import com.test.mongo.util.MongoDBJDBC;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MongoDBTest {

    public static void main(String[] args) throws Exception {
        String table = "test";
        MongoDao dao = new MongoDaoImpl();
        MongoHelper helper = new MongoHelper();

        MongoClient mongoClient = helper.getMongoClient();

        MongoDatabase mongoDatabase = helper.getMongoDataBase(mongoClient);

        Map<String, Object> areaMap1 = new HashMap<String, Object>();
//        areaMap1.put("_id", 2);
        areaMap1.put("北京", 5);
//        areaMap1.put("上海", 14);
//        areaMap1.put("广州", 8);
//        areaMap1.put("深圳", 0.5);

//        dao.insert(mongoDatabase,table,new Document(areaMap1));

        Map<String, Object> areaMap2 = new HashMap<String, Object>();
        Map<String, Object> areaMap3 = new HashMap<String, Object>();
        areaMap2.put("_id", 10);
        areaMap2.put("北京", 5);

        areaMap3.put("_id", 11);
        areaMap3.put("北京", 5);
        List<Document> docList = new ArrayList<Document>();
        docList.add(new Document(areaMap2));
        docList.add(new Document(areaMap3));

//        dao.insertMany(mongoDatabase,table,docList);

//        dao.delete(mongoDatabase,table,new BasicDBObject(areaMap2));
//        dao.deleteOne(mongoDatabase,table,new BasicDBObject(areaMap3));

        Map<String, Object> updateDoc = new HashMap<String, Object>();
        Map<String, Object> wehereDoc = new HashMap<String, Object>();
        wehereDoc.put("_id", 2);
        updateDoc.put("上海", 25);

//      dao.update(mongoDatabase,table,new BasicDBObject(wehereDoc),new BasicDBObject(updateDoc));

        Map<String, Object> map = dao.queryByID(mongoDatabase, table, 2);
        System.out.println("map:" + map);
        List<Map<String, Object>> list1 = dao.queryByDoc(mongoDatabase, table, new BasicDBObject(areaMap1));
        System.out.println("list1:" + list1);
        List<Map<String, Object>> list2 = dao.queryAll(mongoDatabase, "test");
        System.out.println("list2:" + list2);

        helper.closeMongoClient(mongoDatabase, mongoClient);
    }

    public static void test() {
        System.out.println("连接mongoDB");
        MongoDatabase mongoDatabase = MongoDBJDBC.getMongoDatabase("test");
        System.out.println(mongoDatabase.getName());
        MongoCollection<Document> collection = MongoDBJDBC.getCollection(mongoDatabase, "test");
        System.out.println(collection.count());
        Document document = new Document("title", "MongoDB");
        document.append("x", 10);
        document.append("y", 10.12);
//        MongoDBJDBC.insertOne(mongoDatabase,"test",document);
        MongoDBJDBC.removeOne(mongoDatabase, "test", Filters.eq("title", "MongoDB"));
        MongoCursor<Document> mongoCursor = MongoDBJDBC.find(mongoDatabase, "test");
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
        System.out.println("连接mongoDB成功");
    }
}
