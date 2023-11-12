package com.emvalai.meetingservice.query.rest;

import com.emvalai.meetingservice.core.data.MeetingEntity;
import com.emvalai.meetingservice.core.data.MeetingRepository;
import com.emvalai.meetingservice.query.FindMeetingQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MeetingQueryHandler {
    private final MeetingRepository meetingRepository;


    public MeetingQueryHandler(MeetingRepository meetingRepository) {
        this.meetingRepository  = meetingRepository;
    }
    @QueryHandler
    public List<MeetingRestModel> findMeeting(FindMeetingQuery query){
        List<MeetingRestModel> meetingRest = new ArrayList<>();
        List<MeetingEntity> storedMeeting = meetingRepository.findByRole(query.getRole());
        for (MeetingEntity meetingEntity : storedMeeting){
            MeetingRestModel meetingRestModel = new MeetingRestModel();
            BeanUtils.copyProperties(meetingEntity,meetingRestModel);
            meetingRest.add(meetingRestModel);
        }
        return meetingRest;
    }


}
