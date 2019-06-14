package com.telran.hq.tests;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.telran.hq.model.DB;
import com.telran.hq.manager.DBHelper;
import org.bson.Document;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DBConnectionTest {

    @Test
    public void testDBConnection() {


        DB usersDB = new DB("mongodb://server:CjuND8hJ8L84F6N@ds349045.mlab.com:49045/?authSource=ht-profiles"
                , "ht-profiles");
        DBHelper usersDBHelper = new DBHelper(usersDB);
        MongoDatabase database = usersDBHelper.getMongoDB(usersDB);
        MongoCollection<Document> collection = usersDBHelper.getMongoCollection(database, "profile");


        System.out.println(collection.countDocuments());

        List<String> result = new ArrayList<>();
        result = StreamSupport.stream(collection.find().spliterator(), false).map(document -> document.toString())
                .collect(Collectors.toList());
        System.out.println(result.size());


    }


}
