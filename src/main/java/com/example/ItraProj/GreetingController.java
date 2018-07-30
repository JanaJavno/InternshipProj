package com.example.ItraProj;

import com.example.ItraProj.domain.User;
import com.example.ItraProj.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<User> users = userRepo.findAll();

        model.put("users", users);

        return "main";
    }

    @PostMapping
    public String post(@RequestParam String name, @RequestParam String state,
                      Map<String, Object> model){
        User user = new User(name, state);
        userRepo.save(user);
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "main";
    }
    @PostMapping
    public String filter(@RequestParam String name, Map<String, Object> model){
        return "main";
    }
}