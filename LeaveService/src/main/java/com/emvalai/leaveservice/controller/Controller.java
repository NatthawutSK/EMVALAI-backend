package com.emvalai.leaveservice.controller;

import com.emvalai.leaveservice.model.LeaveInfoModel;
import com.emvalai.leaveservice.model.LeaveInfoRestModel;
import com.emvalai.leaveservice.model.UserEntity;
import com.emvalai.leaveservice.repository.LeaveInfoRepository;
import com.emvalai.leaveservice.service.LeaveInfoService;
import com.emvalai.leaveservice.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    LeaveInfoRepository leaveInfoRepository;

    @GetMapping("/getLeaveAll")
    public List<LeaveInfoRestModel> getLeaveAll(){
        List<LeaveInfoRestModel> leaveInfoRestModels = new ArrayList<>();
        List<UserEntity> userEntities = userService.getAllUser();
        List<LeaveInfoModel> leaveInfoModels = leaveInfoService.getAll();
        System.out.println("System1");
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

    @GetMapping("/all")
    public List<LeaveInfoModel> all(){
        return leaveInfoRepository.findAll();
    }
}
