package com.emvalai.calendarservice.query;

import com.emvalai.calendarservice.core.data.CalendarRepository;
import com.emvalai.calendarservice.core.event.MeetingCreatedEvent;
import com.emvalai.emcore.event.MeetingCreateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CalendarEventHandler {
    private final CalendarRepository calendarRepository;
    public  CalendarEventHandler(CalendarRepository calendarRepository){
        this.calendarRepository = calendarRepository;
    }


    @EventHandler
    public void on(MeetingCreateEvent meetingCreateEvent){
        System.out.println("in meeting event");
//        System.out.println("in event created ");
//        ProductEntity productEntity = new ProductEntity();
//        BeanUtils.copyProperties(productCreatedEvent, productEntity);
//        productRepository.save(productEntity);
    }
}
