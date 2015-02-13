package com.lohika.atf.lb.Model;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String name;
    private List<Post> posts = new ArrayList<Post>();

    public Topic(String name, Post post){
        this.name=name;
        posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPost(Post post){
        posts.add(post);
    }
}
