package com.telran.hq.tests;

import com.mongodb.client.MongoCollection;
import com.telran.hq.model.Collection;
import org.bson.Document;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.util.List;

public class DBConnectionTest extends TestBase {

    @Test/*(enabled = false)*/
    public void testDBConnection() {


        MongoCollection<Document> collection = app.usersDB().collection(new Collection(app.usersDB,"profiles"));


        /*System.out.println(collection.countDocuments());*/

        List<String> result = app.usersDB().collectionList(collection);
        /*System.out.println(result.size());*/

        MatcherAssert.assertThat(collection.countDocuments(), CoreMatchers.equalTo(((long) result.size())));

    }

 }
