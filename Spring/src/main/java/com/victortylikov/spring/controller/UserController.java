package com.victortylikov.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.victortylikov.spring.domain.User;
import com.victortylikov.spring.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
 
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(ModelMap map)
    {
        map.addAttribute("user", new User());
        map.addAttribute("listUsers", userService.findAllUsers());
 
        return "listUsers";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value="user") User user, BindingResult result)
    {
    	userService.addUser(user);
        return "redirect:/users";
    }
	
}