package com.telran.hq.manager;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.telran.hq.model.DB;
import org.bson.Document;


public class DBHelper {
    DB db;

    public DBHelper(DB db) {
        this.db=db;
    }

    public MongoCollection<Document> getMongoCollection(MongoDatabase database, String collectionName) {
        return database.getCollection(collectionName);
    }

    public MongoDatabase getMongoDB(DB db) {
        MongoClient mongoClient = MongoClients.create(db.getUri());
        return mongoClient.getDatabase(db.getDatabaseName());
    }
}
