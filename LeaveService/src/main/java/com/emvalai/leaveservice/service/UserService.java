package com.emvalai.leaveservice.service;

import com.emvalai.leaveservice.model.LeaveInfoModel;
import com.emvalai.leaveservice.model.UserEntity;
import com.emvalai.leaveservice.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUser(){
        System.out.println("LOG1");
        return userRepository.findAll();
    }


}
