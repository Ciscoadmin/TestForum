package com.lohika.atf.lb.controller;

import com.lohika.atf.lb.Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("person")
public class controller {

    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public ModelAndView login(SessionStatus status){
        status.setComplete();
        ModelAndView model = new ModelAndView();
        model.addObject("message","Welcome to simple forum");
        model.setViewName("login");
        return model;
    }

   @RequestMapping(value="/login", method=RequestMethod.POST)
   public ModelAndView  performLogin( String login,  String password, HttpSession httpSession) {
       ModelAndView model = new ModelAndView();

       //System.out.println("You enter login : "+login);
       //System.out.println("You enter password : "+password);

       if (UsersDB.users.containsKey(login)) {
           Person user = UsersDB.users.get(login);
           if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
               System.out.println("!!!!!!!!!!!Auth. was passed!!!!!!!!!!!!!!!!!");
               httpSession.setAttribute("person", new Person(login,password) );
               model.addObject("user", login);
               if(login.equals("admin")){
                   model.addObject("ifAdmin", "  Add topic  ");
               }
               model.addObject("message","Welcome to Forum");
               model.addObject("topics", TopicPostDB.topics3.keySet());
               model.setViewName("main");
               return model;

           }
       }
//           System.out.println("@@@@@@@@@@@@@@@ Something Wrong @@@@@@@@@@@@@@@@@@@@");
           //generating  error
           model.addObject("message", "We are  sorry,");
           model.addObject("error", "Incorrect login or password! Try again");
           model.setViewName("login");
           return model;
   }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView reg(){
        ModelAndView model = new ModelAndView();
        model.addObject("message","Registration Form");
        model.setViewName("register");
        return model;
    }
    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ModelAndView  performReg( String login,  String password) {
        ModelAndView model = new ModelAndView();

        //System.out.println("You enter login : "+login);
        //System.out.println("You enter password : "+password);

        if (login.isEmpty()||password.isEmpty() || UsersDB.users.containsKey(login) ) {
            System.out.println("@@@@@@@@@@@@@@@ Something Wrong @@@@@@@@@@@@@@@@@@@@");
            //generating  error
            model.addObject("message", "We are  sorry,");
            model.addObject("error", "Please fill all fields ! Or choose  another login");
            model.setViewName("register");
            return model;
        }
        UsersDB.users.put(login,new Person(login,password));
        model.addObject("message", "Welcome  to our forum");
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/{topic}", method = RequestMethod.GET)
    public ModelAndView showTopic( @PathVariable String topic) {
        ModelAndView model = new ModelAndView();
        if (!TopicPostDB.topics3.containsKey(topic)) {
            model.addObject("message", "Try again");
            model.setViewName("login");
            return model;
        }
        model.addObject("topic", TopicPostDB.topics3.get(topic));
        model.addObject("valueOfTopic", topic);
        model.setViewName("topic");
        return model;
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.GET)
    public ModelAndView addpost( @RequestParam (value = "valueOfTopic", required = true) String valueOfTopic)
    {
        ModelAndView model = new ModelAndView();
        model.addObject("topic", valueOfTopic);
        model.setViewName("addpost");
        return model;
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public ModelAndView addpost( String topicName, String text, @ModelAttribute Person person){

       System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println(topicName);
        System.out.println(text);
        System.out.println(person.getLogin());
        System.out.println("+++++++++++++++++++++++++++++++++++++");

        ModelAndView model = new ModelAndView();
        if (text==null || text=="") {
            model.addObject("topic", topicName);
            model.addObject("message", "Text can't be empty");
            model.setViewName("addpost");
            return model;
         }

        TopicPostDB.topics3.get(topicName).addPost(new Post(person.getLogin(),text));

        model.addObject("topic", TopicPostDB.topics3.get(topicName));
        model.addObject("valueOfTopic", topicName);
        model.setViewName("topic");
        return model;
    }
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main(  @ModelAttribute Person person){

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        //System.out.println(topicName);
        //System.out.println(text);
        System.out.println(person.getLogin());
        System.out.println("+++++++++++++++++++++++++++++++++++++");

        ModelAndView model = new ModelAndView();
        if(person.getLogin().equals("admin")){
            model.addObject("ifAdmin", "Add topic");
        }
        model.addObject("user", person.getLogin());
        model.addObject("message", "Welcome to Forum");
        model.addObject("topics", TopicPostDB.topics3.keySet());
        model.setViewName("main");
        return model;
    }

    @RequestMapping(value = "/addtopic", method = RequestMethod.GET)
    public ModelAndView addTopic( @ModelAttribute Person person)
    {
        ModelAndView model = new ModelAndView();
        if(person.getLogin().equals("admin")){
            model.addObject("message","Please enter topic tittle");
            model.addObject("text", "some text");
            model.setViewName("addtopic");
            return model;
        }
        model.addObject("message", "Welcome  to our forum");
        model.setViewName("login");
        return model;
    }


    @RequestMapping(value = "/addtopic", method = RequestMethod.POST)
    public ModelAndView addTopic(String topicName, String text,@ModelAttribute Person person)

    {
        ModelAndView model = new ModelAndView();
        if (topicName==null || topicName=="")
            return new ModelAndView("addTopic","message","Topic name can't be empty");
        if (text==null || text=="")
            return new ModelAndView("addTopic","message","Text can't be empty");

        if (TopicPostDB.topics3.containsKey(topicName))
            return new ModelAndView("addTopic","message","This topic already exist");

        TopicPostDB.topics3.put(topicName,new Topic(topicName,new Post(person.getLogin(),text)));

        model.addObject("ifAdmin", "Add topic");
        model.addObject("user", person.getLogin());
        model.addObject("message", "Welcome to Forum");
        model.addObject("topics", TopicPostDB.topics3.keySet());
        model.setViewName("main");
        return model;
    }

/*
    //testing redirect
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String goHome(){
        return  "redirect:/health";
    }
*/
}