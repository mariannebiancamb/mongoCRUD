package com.mongo.crud.controller;

import com.mongo.crud.DTO.UpdateDTO;
import com.mongo.crud.DTO.UserDTO;
import com.mongo.crud.documents.User;
import com.mongo.crud.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create
    @PostMapping
    public User addUser(@RequestBody User userDTO){
        return userService.addUser(userDTO);
    }

    //Retrieve
    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    //Update
    @PutMapping
    public User updatePassword(@RequestBody UpdateDTO updateDTO){
        return userService.updatePassword(updateDTO);
    }

    //Deelte
    @DeleteMapping("{login}")
    public User deleteUserbylogin(@PathVariable String login){
        return userService.deleteUserBylogin(login);
    }

}
