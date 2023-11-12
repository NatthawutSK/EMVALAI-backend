package com.emvalai.meetingservice.controller;

import com.emvalai.meetingservice.repository.MeetingEntity;
import com.emvalai.meetingservice.service.MeetingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
    private final MeetingService service;
    @Autowired
    public MeetingController(MeetingService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<?> getMeetingByRole(@RequestHeader("role") String role){
        List<MeetingEntity> meetingEntityList = service.getMeetingByRole(role);
        return ResponseEntity.ok(meetingEntityList);
    }
    @PostMapping
    public ResponseEntity<?> createMeeting(@RequestHeader("role") String role,@RequestBody MeetingRestModel model){
        if(role.equals("Supervisor") || role.equals("Manager")){
            MeetingEntity meetingEntity = new MeetingEntity();
            BeanUtils.copyProperties(model,meetingEntity);
            service.createMeeting(meetingEntity);
        }
        else{
            return ResponseEntity.status(401).body("NOT ALLOWED");
        }

        return ResponseEntity.ok("OK");

    }
}
