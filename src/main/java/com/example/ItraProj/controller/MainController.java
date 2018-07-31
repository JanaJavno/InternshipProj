package com.example.ItraProj.controller;

import com.example.ItraProj.domain.User;
import com.example.ItraProj.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<User> users = userRepo.findAll();

        model.put("users", users);

        return "main";
    }

    /*@PostMapping("/main")
    public String post(@RequestParam String name,
                       @RequestParam boolean state, Map<String, Object> model){
        User user = new User(name, state);
        userRepo.save(user);
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "main";
    }*/
}