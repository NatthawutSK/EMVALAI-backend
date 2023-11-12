package com.emvalai.meetingservice.core.event;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MeetingCreatedEvent {
    private String meet_id;
    private String meet_title;
    private String meet_description;
    private LocalDateTime meet_date;
    private String created_by;
    private List<String> role;
}
