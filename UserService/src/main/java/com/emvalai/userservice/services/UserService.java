package com.emvalai.userservice.services;

import com.emvalai.userservice.entities.UserEntity;
import com.emvalai.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    public Boolean addUser(UserEntity user){
        UserEntity userEntity = userRepository.findByEmail(user.getEmail());
        if (userEntity != null){
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
    }

    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity UpdateUser(UserEntity user){
        UserEntity found = userRepository.findByUserId(user.get_id());
        if (found == null){
            return null;
        }
        UserEntity updatedUser = userRepository.save(user);
        return updatedUser;
    }


    public UserEntity getUserById(String userId){
        return userRepository.findByUserId(userId);
    }


    public List<UserEntity> getUserByRole(String role){
        return userRepository.findByRole(role);

    }
}
