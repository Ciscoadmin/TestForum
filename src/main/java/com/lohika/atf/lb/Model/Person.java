package com.lohika.atf.lb.Model;

//import org.hibernate.validator.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

public class Person {

//  @NotEmpty (message = "Please enter your login.")
    private String login;

//  @NotEmpty (message = "Please enter your password.")
    private String password;

    public Person(String login, String password)
    {
        this.login=login;
        this.password=password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}
