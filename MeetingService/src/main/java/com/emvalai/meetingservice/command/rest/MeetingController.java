package com.emvalai.meetingservice.command.rest;

import com.emvalai.meetingservice.command.CreateMeetingCommand;
import com.emvalai.meetingservice.core.data.MeetingEntity;
import com.emvalai.meetingservice.service.MeetingService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
//    private final MeetingService service;
private final CommandGateway commandGateway;
    @Autowired
    public MeetingController( CommandGateway commandGateway) {
        this.commandGateway = commandGateway;

    }
//    @GetMapping
//    public ResponseEntity<?> getMeetingByRole(@RequestHeader("role") String role){
//        List<MeetingEntity> meetingEntityList = service.getMeetingByRole(role);
//        return ResponseEntity.ok(meetingEntityList);
//    }
   @PostMapping
    public String createMeeting(@RequestHeader("role") String role,@RequestBody MeetingRestModel model){
        if(role.equals("Supervisor") || role.equals("Manager")){
            CreateMeetingCommand command = CreateMeetingCommand.builder()
                    .meet_id(UUID.randomUUID().toString())
                    .meet_title(model.getMeet_title())
                    .meet_description(model.getMeet_description())
                    .meet_date(model.getMeet_date())
                    .created_by(model.getCreated_by())
                    .role(model.getRole())
                    .build();
            String result;
            try{
                result = commandGateway.sendAndWait(command);
            }
            catch (Exception e){
                result = e.getLocalizedMessage();
            }
            return result;
        }
        else{
            return "Not Allowed Only Manager and Supervisor";
        }



    }
}
