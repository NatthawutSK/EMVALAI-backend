package com.emvalai.meetingservice.query.rest;

import com.emvalai.meetingservice.query.FindMeetingQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meeting")

public class MeetingQueryController {
    private final QueryGateway queryGateway;

    public MeetingQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<MeetingRestModel> getMeetingByRole(@RequestHeader("role") String role){
        FindMeetingQuery findMeetingQuery = new FindMeetingQuery(role);
        return queryGateway.query(
                findMeetingQuery,
                ResponseTypes.multipleInstancesOf(MeetingRestModel.class)
        ).join();
    }

}
