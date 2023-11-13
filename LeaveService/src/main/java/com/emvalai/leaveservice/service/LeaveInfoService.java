package com.emvalai.leaveservice.service;

import com.emvalai.leaveservice.model.LeaveInfoModel;
import com.emvalai.leaveservice.model.LeaveInfoRestModel;
import com.emvalai.leaveservice.repository.LeaveInfoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveInfoService {
    @Autowired
    private LeaveInfoRepository leaveInfoRepository;
    public boolean createLeaveInfo(LeaveInfoModel leaveInfoModel){
        try{
            leaveInfoRepository.save(leaveInfoModel);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }finally {
            System.out.println("Crate LeaveInfo");
        }

    }

//    @RabbitListener(queues = "GetLeaveQueue")
    public List<LeaveInfoModel> getAll(){
        System.out.println("LOG2");
        return leaveInfoRepository.findAll();
    }

}
