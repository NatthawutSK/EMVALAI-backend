package com.emvalai.leaveservice.controller;

import com.emvalai.leaveservice.model.LeaveInfoModel;
import com.emvalai.leaveservice.model.LeaveInfoRestModel;
import com.emvalai.leaveservice.model.UserEntity;
import com.emvalai.leaveservice.service.LeaveInfoService;
import com.emvalai.leaveservice.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/leave")
public class Controller{

    @Autowired
    private LeaveInfoService leaveInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    LeaveInfoRepository leaveInfoRepository;

    @GetMapping("/leaves")
    public List<LeaveInfoRestModel> getLeaveAllWithUserInfo(){
        List<LeaveInfoRestModel> leaveInfoRestModels = new ArrayList<>();
        List<UserEntity> userEntities = userService.getAllUser();
        List<LeaveInfoModel> leaveInfoModels = leaveInfoService.getAll();
        System.out.println(userEntities);
        System.out.println(leaveInfoModels);
        for (LeaveInfoModel leaveModel: leaveInfoModels){
            System.out.println("EMP");
            System.out.println(leaveModel.getEmp_id());
            for (UserEntity user: userEntities){
                System.out.println("UID");
                System.out.println(user.get_id());
                if (leaveModel.getEmp_id().equals(user.get_id())){
                    LeaveInfoRestModel info = new LeaveInfoRestModel();
                    info.setEmp_id(user.get_id());
                    info.setLeave_id(leaveModel.getLeave_id());
                    info.setLeave_type(leaveModel.getLeave_type());
                    info.setEnd_date(leaveModel.getEnd_date());
                    info.setStart_date(leaveModel.getStart_date());
                    info.setLeave_status(leaveModel.isLeave_status());
                    info.setFirstName(user.getFName());
                    info.setLastName(user.getLName());
                    info.setRole(user.getRole());
                    leaveInfoRestModels.add(info);
                }
            }
        }

        return leaveInfoRestModels;
    }

    @GetMapping("/getAll")
    public List<LeaveInfoModel> getLeaves(){
        return leaveInfoService.getAll();
    }

    @PostMapping("/create")
    public boolean create(@RequestBody LeaveInfoModel model){
        model.setLeave_status(false);
        return leaveInfoService.createLeaveInfo(model);
    }

    @PutMapping("/approve/{leave_id}/{status}")
    public boolean setApprove(@PathVariable("leave_id") int leave_id, @PathVariable("status") boolean status){
        return leaveInfoService.setApproveInfo(leave_id, status);
    }

}
