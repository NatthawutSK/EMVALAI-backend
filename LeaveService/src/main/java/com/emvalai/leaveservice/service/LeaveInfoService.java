package com.emvalai.leaveservice.service;

import com.emvalai.leaveservice.model.LeaveInfoModel;
import com.emvalai.leaveservice.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveInfoService {
    @Autowired
    private MyRepository leaveRepository;
    public boolean createLeaveInfo(LeaveInfoModel leaveInfoModel){
        try{
            leaveRepository.save(leaveInfoModel);
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
        return leaveRepository.findAll();
    }

    public boolean setApproveInfo(int leave_id,boolean setter){
        LeaveInfoModel leaveInfoModel = leaveRepository.findByLeaveId(leave_id);
        if (leaveInfoModel != null){
            leaveInfoModel.setLeave_status(setter);
            leaveRepository.save(leaveInfoModel);
            return true;
        }else{
            return false;
        }
    }

}
