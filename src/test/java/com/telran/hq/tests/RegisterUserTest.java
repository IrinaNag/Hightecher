package com.telran.hq.tests;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.telran.hq.model.Collection;
import com.telran.hq.model.User;
import org.bson.Document;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class RegisterUserTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){}

    @Test
    public void testRegisterUser() throws Exception {

        MongoDatabase userDatabase = app.usersDB().database(app.usersDB);
        String collectionName="profilles";

        long before= app.usersDB().collection(userDatabase,collectionName).countDocuments();

        app.goTo().registrationPage();
        User user=User.builder().username("asdfg").name("hgfhgfh").surname("ffhgfhd")
                .email("ghgdhd@hjhkj.com").phone("0549874567").password("1asdfghA#").password_confirmation("1asdfghA#").build();
        app.user().registration(user);

        long after= app.usersDB().collection(userDatabase,collectionName).countDocuments();

        /*assertThat(app.user().getAlertText(), equalTo(""));*/
        assertThat(after, equalTo(before+1));
    }



}
