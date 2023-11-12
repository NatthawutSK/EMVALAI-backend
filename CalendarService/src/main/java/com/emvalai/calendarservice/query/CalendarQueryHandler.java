package com.emvalai.calendarservice.query;

import com.emvalai.calendarservice.core.data.CalendarEntity;
import com.emvalai.calendarservice.core.data.CalendarRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalendarQueryHandler {
    private final CalendarRepository calendarRepository;
    public CalendarQueryHandler(CalendarRepository calendarRepository){
        this.calendarRepository = calendarRepository;
    }
    //List<CalendarRestModel>
    @QueryHandler
    public List<CalendarRestModel> findCalendarByUserId(FindCalendarQuery query){
        System.out.println(query.getUserId());
        List<CalendarRestModel> restModelList = new ArrayList<>();
        List<CalendarEntity> calendarEntities = calendarRepository.findByUserId(query.getUserId());
//        List<ProductRestModel> productRest = new ArrayList<>();
//        List<ProductEntity> storedProducts = productRepository.findAll();
        for (CalendarEntity calendar  : calendarEntities){
            CalendarRestModel calendarRestModel = new CalendarRestModel();
            BeanUtils.copyProperties(calendar, calendarRestModel);
            restModelList.add(calendarRestModel);
        }
        return restModelList;
    }
}
