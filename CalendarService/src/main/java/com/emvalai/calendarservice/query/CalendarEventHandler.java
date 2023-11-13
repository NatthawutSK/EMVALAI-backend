package com.emvalai.calendarservice.query;

import com.emvalai.calendarservice.core.data.CalendarEntity;
import com.emvalai.calendarservice.core.data.CalendarRepository;
import com.emvalai.calendarservice.core.data.User;
import com.emvalai.calendarservice.core.event.MeetingCreatedEvent;
import com.emvalai.emcore.event.MeetingCreateEvent;

import com.emvalai.emcore.event.UserOnlyId;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalendarEventHandler {
    private final CalendarRepository calendarRepository;
    public  CalendarEventHandler(CalendarRepository calendarRepository){
        this.calendarRepository = calendarRepository;
    }


    @EventHandler
    public void on(MeetingCreateEvent meetingCreateEvent){
        System.out.println("in meeting event" + meetingCreateEvent);
        List<UserOnlyId> userList = new ArrayList<>();

        for (String role : meetingCreateEvent.getRole()) {
            ResponseEntity<List<UserOnlyId>> responseEntity = new RestTemplate().exchange(
                    "http://localhost:8080/user/getUserByRole/" + role,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<UserOnlyId>>() {}
            );
            List<UserOnlyId> users = responseEntity.getBody();
            if (users != null) {
                userList.addAll(users);
            }
        }


        List<CalendarEntity> calendarEntities = new ArrayList<>();
        for (UserOnlyId user : userList) {
            CalendarEntity calendar = CalendarEntity.builder()
                    .title(meetingCreateEvent.getMeet_title())
                    .start(meetingCreateEvent.getMeet_date().toString())
                    .desc(meetingCreateEvent.getMeet_description())
                    .userId(user.getUserId())
                    .build();
            calendarEntities.add(calendar);
//            System.out.println(user.getUserId());
        }

        calendarRepository.saveAll(calendarEntities);

//        System.out.println(calendarEntities);

    }
}
