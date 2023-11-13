package com.emvalai.userservice.services;

import com.emvalai.userservice.entities.EditImageEntity;
import com.emvalai.userservice.entities.EditUser;
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

    public Boolean UpdateUser(EditUser editUser){
        UserEntity user1 = userRepository.findByUserId(editUser.get_id());
        if (user1 == null){
            return false;
        } else {
            UserEntity userEntity = UserEntity.builder()
                    ._id(user1.get_id())
                    .fName(editUser.getFName())
                    .lName(editUser.getLName())
                    .dob(editUser.getDob())
                    .phone(editUser.getPhone())
                    .gender(user1.getGender())
                    .email(editUser.getEmail())
                    .hireDate(user1.getHireDate())
                    .password(user1.getPassword())
                    .position(user1.getPosition())
                    .image(user1.getImage())
                    .role(user1.getRole())
                    .build();
            userRepository.save(userEntity);
            return true;
        }

    }


    public UserEntity getUserById(String userId){
        return userRepository.findByUserId(userId);
    }


    public List<UserEntity> getUserByRole(String role){
        return userRepository.findByRole(role);
    }


    public Boolean EditImageUser(EditImageEntity editImageEntity){
        UserEntity user = userRepository.findByUserId(editImageEntity.get_id());
        if (user == null){
            return false;
        } else {
            UserEntity userEntity = UserEntity.builder()
                    ._id(user.get_id())
                    .fName(user.getFName())
                    .lName(user.getLName())
                    .dob(user.getDob())
                    .phone(user.getPhone())
                    .gender(user.getGender())
                    .email(user.getEmail())
                    .hireDate(user.getHireDate())
                    .password(user.getPassword())
                    .position(user.getPosition())
                    .image(editImageEntity.getImage())
                    .role(user.getRole())
                    .build();
            userRepository.save(userEntity);
            return true;
        }


    }
}
