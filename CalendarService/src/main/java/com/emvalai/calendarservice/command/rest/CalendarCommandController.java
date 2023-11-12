package com.emvalai.calendarservice.command.rest;

import com.emvalai.calendarservice.core.data.CalendarEntity;
import com.emvalai.calendarservice.core.data.CalendarRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class CalendarCommandController {
    private final CommandGateway commandGateway;
    @Autowired
    public CalendarCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Autowired
    public CalendarRepository calendarRepository;
    @PostMapping
    public CalendarEntity createCalendar(@RequestBody CalendarEntity model){
          return calendarRepository.save(model);
//        CreateCalendarCommand command = CreateCalendarCommand.builder()
//                .userId(UUID.randomUUID().toString())
//                .title(model.getTitle())
//                .start(model.getStart())
//                .desc(model.getDesc())
//                .build();
//        String result;
//        try {
//            result = commandGateway.sendAndWait(command);
//        } catch (Exception e){
//            result = e.getLocalizedMessage();
//        }
//        return result;
    }


}
