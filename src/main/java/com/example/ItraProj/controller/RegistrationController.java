package com.example.ItraProj.controller;

import com.example.ItraProj.domain.Role;
import com.example.ItraProj.domain.User;
import com.example.ItraProj.repository.UserRegistrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRegistrRepo userRegistrRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRegistrRepo.findByUsername((user.getUsername()));
        if (userFromDb != null){
            model.put("message", "User exists!");
            return "registration";
        }
        user.setState(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRegistrRepo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/delete/{id}")
    public void delete (@PathVariable(value = "id") Long id){
        userRegistrRepo.deleteById(id);
    }
}
