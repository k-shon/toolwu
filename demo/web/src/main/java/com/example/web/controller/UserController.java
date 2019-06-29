package com.example.web.controller;

import com.example.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class UserController {
    @RequestMapping("/user")
    public String index(Model model){
        User user = new User("1111","kshon");
        ArrayList<User> users = new ArrayList<User>();
        User u1 = new User("2222","aaa");
        User u2 = new User("3333","bbbb");
        User u3 = new User("4444","ccccc");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        model.addAttribute("user",user);
        model.addAttribute("users",users);
        return "index";
    }
}
