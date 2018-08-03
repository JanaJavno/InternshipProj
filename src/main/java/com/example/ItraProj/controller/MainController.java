package com.example.ItraProj.controller;

import com.example.ItraProj.domain.User;
import com.example.ItraProj.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String main(Model model){
        Iterable<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "main";
    }
}