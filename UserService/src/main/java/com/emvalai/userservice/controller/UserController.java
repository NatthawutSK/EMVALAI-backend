package com.emvalai.userservice.controller;

import com.emvalai.userservice.entities.ResponseRegister;
import com.emvalai.userservice.entities.UserEntity;
import com.emvalai.userservice.entities.UserRestModel;
import com.emvalai.userservice.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserRestModel> getUser(@RequestHeader("userId") String userId, @RequestHeader("email") String email){
        System.out.println("userId " + userId);
        System.out.println("email " + email);
        List<UserRestModel> usersRest = new ArrayList<>();
        List<UserEntity> storedUsers =  userService.getAllUser();
        for (UserEntity userEntity : storedUsers){
            UserRestModel userRestModel = new UserRestModel();
            BeanUtils.copyProperties(userEntity, userRestModel);
            usersRest.add(userRestModel);
        }
        return usersRest;
    }

    @GetMapping("/getAllUser")
    public List<UserEntity> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/login/{email}")
    public UserEntity checkLogin(@PathVariable("email") String email){
        return userService.findByEmail(email);
    }

    @PostMapping("/register")
    public ResponseRegister addUser(@RequestBody UserEntity user){
        if (userService.addUser(user)){
            return new ResponseRegister(true,"Register Success");
        } else {
            return new ResponseRegister(false,"Email Already use");
        }

    }

    @PostMapping("/edit")
    public ResponseEntity<?> UpdateUser(@RequestBody UserEntity user){
        UserEntity userEntity = userService.UpdateUser(user);
        if (userEntity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok(userEntity);
    }

    @GetMapping("/getUserbyId/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") String userId){
        System.out.println("userId "+ userId);
        UserEntity userEntity = userService.getUserById(userId);
        UserRestModel userRestModel = new  UserRestModel();
        BeanUtils.copyProperties(userEntity, userRestModel);
        return ResponseEntity.ok(userRestModel);
    }


//    @GetMapping("/getUserByProj")
//    public ResponseEntity<?> getUserName(){
//
//    }


}
