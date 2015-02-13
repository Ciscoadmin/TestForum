package com.lohika.atf.lb;

import com.lohika.atf.lb.Model.*;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;




@Configuration
@ComponentScan({ "com.lohika.atf.lb.**" })
@EnableAutoConfiguration

public class Forum {

    public static void main(String[] args){
        //Init values
        UsersDB.users.put("admin",new Person("admin","admin"));
        UsersDB.users.put("demo",new Person("demo","demo"));
        TopicPostDB.topics3.put("Test topic",new Topic("Test topic",new Post("demo","Test message")));
        TopicPostDB.topics3.get("Test topic").addPost(new Post("admin","Next Post"));
        TopicPostDB.topics3.put("Test2 topic",new Topic("Test2 topic",new Post("demo","Test#2 message")));

        SpringApplication.run(Forum.class, args);
    }


}
