package com.elpisor.hq.tests;

import com.mongodb.client.MongoCollection;
import com.elpisor.hq.model.Collection;
import org.bson.Document;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.util.List;

public class DBConnectionTest extends TestBase {

    @Test/*(enabled = false)*/
    public void testDBConnection() {


        MongoCollection<Document> collection = app.usersDB().collection(new Collection(app.usersDB,"profiles"));
        long numberOfDocuments = collection.countDocuments();



        List<String> result = app.usersDB().collectionList(collection);





        MatcherAssert.assertThat(numberOfDocuments, CoreMatchers.equalTo(((long) result.size())));

    }

 }
