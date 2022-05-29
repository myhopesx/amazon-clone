package com.example.amazonclone.controller;

import com.example.amazonclone.model.User;
import com.example.amazonclone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody @Valid User user, Errors error){

        if (error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(201).body("Welcome to our Amazon website!!!!");
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody @Valid User user, Errors errors ){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(user);
        return ResponseEntity.status(200).body("User has updated");
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity deleteUser(@PathVariable String userid){

        if(!userService.deleteUser(userid)){
            return ResponseEntity.status(400).body("there is no user");
        }
        return ResponseEntity.status(200).body("user has deleted");
    }

}
