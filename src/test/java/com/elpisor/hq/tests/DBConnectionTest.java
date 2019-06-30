package com.elpisor.hq.tests;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DBConnectionTest extends TestBase {

    @Test/*(enabled = false)*/
    public void testDBConnection() {


        /*MongoCollection<Document> collection = app.usersDB()
                .collection(app.usersDB().database(app.getProperties().getProperty("usersDatabase.name"))
                        ,app.getProperties().getProperty("usersDatabase.profileCollectionName"));*/

        System.out.println(app.getMongoUser().listDatabaseNames());

        MongoDatabase database=app.getMongoUser().getDatabase(app.getProperties().getProperty("usersDatabase.name"));



        MongoCollection collection=database.getCollection(app.getProperties().getProperty("usersDatabase.profileCollectionName"));
        System.out.println(collection.countDocuments());
        long numberOfDocuments = collection.countDocuments();



        List<String> result = app.usersDB().collectionList(collection);

        System.out.println(result);


        assertThat(numberOfDocuments, equalTo(((long) result.size())));

    }

 }
