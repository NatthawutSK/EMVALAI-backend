package com.emvalai.meetingservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
public class CreateMeetingCommand {
    @TargetAggregateIdentifier
        private final String meet_id;
        private final String meet_title;
        private final String meet_description;
        private final LocalDateTime meet_date;
        private final String created_by;
        private final List<String> role;

}
