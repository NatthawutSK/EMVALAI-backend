package com.emvalai.meetingservice;

import com.emvalai.emcore.event.MeetingCreateEvent;
import com.emvalai.meetingservice.core.data.MeetingEntity;
import com.emvalai.meetingservice.core.data.MeetingRepository;
import com.emvalai.meetingservice.core.event.MeetingCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MeetingEventHandler {

    private final MeetingRepository meetingRepository;

    public MeetingEventHandler(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @EventHandler
    public void on(MeetingCreateEvent event){
        MeetingEntity meetingEntity = new MeetingEntity();
        BeanUtils.copyProperties(event, meetingEntity);
        meetingRepository.save(meetingEntity);
    }
}
