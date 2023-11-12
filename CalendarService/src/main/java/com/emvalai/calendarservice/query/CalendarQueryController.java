package com.emvalai.calendarservice.query;

import com.emvalai.calendarservice.core.data.CalendarRepository;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarQueryController {

    private final QueryGateway queryGateway;

    private final CalendarRepository calendarRepository;
    @Autowired
    public CalendarQueryController(QueryGateway queryGateway, CalendarRepository calendarRepository){
        this.queryGateway = queryGateway;
        this.calendarRepository = calendarRepository;
    }

    //List<CalendarRestModel>
    @GetMapping
    public List<CalendarRestModel> getCalendarByUserId(@RequestHeader("userId") String userId){
        FindCalendarQuery findCalendarQuery = new FindCalendarQuery(userId);
        System.out.println(userId);
        return queryGateway.query(findCalendarQuery,
                ResponseTypes.multipleInstancesOf(CalendarRestModel.class)
        ).join();

    }

}
