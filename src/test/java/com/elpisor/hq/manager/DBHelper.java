package com.elpisor.hq.manager;

import com.elpisor.hq.model.DBase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.elpisor.hq.model.Collection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class DBHelper extends HelperBase{
    DBase db;

    public DBHelper(DBase db) {
        super();
        this.db=db;
    }

    public MongoCollection<Document> collection (Collection collection){
        return database(collection.database).getCollection(collection.collectionName);
    }

    public MongoCollection<Document> collection(MongoDatabase database, String collectionName) {
        return database.getCollection(collectionName);
    }

    public MongoDatabase database(DBase db) {
        MongoClient mongoClient = MongoClients.create(db.getUri());
        return mongoClient.getDatabase(db.getDatabaseName());
    }

    public List<String> collectionList(MongoCollection<Document> collection) {
        List<String> result = new ArrayList<>();
        result = StreamSupport.stream(collection.find().spliterator(), false).map(document -> document.toString())
                .collect(Collectors.toList());
        return result;
    }

}
