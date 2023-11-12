package com.emvalai.meetingservice.command.rest;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class MeetingRestModel {
    private String meet_title;
    private String meet_description;
    private LocalDateTime meet_date;
    private String created_by;
    private List<String> role;
}
