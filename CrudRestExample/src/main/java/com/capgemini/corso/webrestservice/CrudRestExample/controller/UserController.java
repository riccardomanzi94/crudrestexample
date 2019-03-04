package com.capgemini.corso.webrestservice.CrudRestExample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.corso.webrestservice.CrudRestExample.entity.User;
import com.capgemini.corso.webrestservice.CrudRestExample.service.UserService;



@RestController
public class UserController {
	
	
	
	@Autowired
    @Qualifier("userService")
    private UserService userService;
 

	
    @PostMapping("createuser")
    public void createNewUser(@Valid @RequestBody User user) {
        userService.addUser(user);
    }
 
    @PutMapping("changeuser")
    public void changeExistingUser(@Valid @RequestBody User user) {
        userService.modifyUser(user);
    }
 
    @DeleteMapping("removeuser/{id}")
    public void removeUser(@PathVariable(value = "id") long userId) {
        userService.removeUser(userId);
    }
 
    @GetMapping("viewsingleuser/{id}")
    public User viewUserById(@PathVariable(value = "id") long userId) {
        return userService.getUserById(userId);
    }
 
    @GetMapping("viewalluser")
    public List<User> viewAllUser() {
        return userService.getAllUser();
    }

}
