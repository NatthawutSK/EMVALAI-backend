package com.emvalai.meetingservice.service;

import com.emvalai.meetingservice.repository.MeetingEntity;
import com.emvalai.meetingservice.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    private final MeetingRepository repository;
    @Autowired
    public MeetingService(MeetingRepository repository) {
        this.repository = repository;
    }

    public List<MeetingEntity> getAllMeeting(){
       return repository.findAll();
    }

    public void createMeeting(MeetingEntity meeting){
        repository.save(meeting);
    }

    public List<MeetingEntity> getMeetingByRole(String role){
        return repository.findByRole(role);
    }


}
