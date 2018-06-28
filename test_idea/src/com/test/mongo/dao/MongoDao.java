package com.test.mongo.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;
import java.util.Map;

/**
 * Dao 层接口
 *
 */
public interface MongoDao {

    /**
     * Get Data BY ID
     * @param db
     * @param table
     * @param Id
     * @return
     * @throws Exception
     */
    public Map<String,Object> queryByID(MongoDatabase db, String table, Object Id) throws Exception;

    /**
     *
     * @param db
     * @param table
     * @param doc
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> queryByDoc(MongoDatabase db, String table, BasicDBObject doc) throws Exception;

    /**
     *
     * @param db
     * @param table
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> queryAll(MongoDatabase db, String table) throws Exception;

    /**
     * Insert Data
     * @param db
     * @param table
     * @param document
     * @return
     */
    public boolean insert(MongoDatabase db, String table, Document document)throws Exception;

    /**
     *
     * @param db
     * @param table
     * @param documents
     * @return
     * @throws Exception
     */
    public boolean insertMany(MongoDatabase db, String table, List<Document> documents )throws Exception;
    /**
     * Delete Many Data.if doc is empty will delete all Data
     * @param db
     * @param table
     * @param document
     * @return
     */
    public boolean delete(MongoDatabase db, String table, BasicDBObject document)throws Exception;
    /**
     *
     * @param db
     * @param table
     * @param document
     * @return
     * @throws Exception
     */
    public boolean deleteOne(MongoDatabase db, String table, BasicDBObject document)throws Exception;

    /**
     * Update All Data
     * @param db
     * @param table
     * @param whereDoc
     * @param updateDoc
     * @return
     */
    public boolean update(MongoDatabase db, String table, BasicDBObject whereDoc, BasicDBObject updateDoc)throws Exception;

    /**
     * 修改一个
     * @param db
     * @param table
     * @param whereDoc
     * @param updateDoc
     * @return
     * @throws Exception
     */
    public boolean updateOne(MongoDatabase db, String table, BasicDBObject whereDoc,BasicDBObject updateDoc) throws Exception;
}
