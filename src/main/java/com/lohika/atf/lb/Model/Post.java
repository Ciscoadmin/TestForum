package com.lohika.atf.lb.Model;


public class Post {

    private String username;
    private String content;

    public Post(String login, String message){
        this.username=login;
        this.content=message;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
