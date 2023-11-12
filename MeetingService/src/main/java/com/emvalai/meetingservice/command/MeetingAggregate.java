package com.emvalai.meetingservice.command;

import com.emvalai.meetingservice.core.event.MeetingCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;

@Aggregate
public class MeetingAggregate {
    @AggregateIdentifier
    private String meet_id;
    private String meet_title;
    private String meet_description;
    private LocalDateTime meet_date;
    private String created_by;
    private List<String> role;

    public MeetingAggregate(){};

    @CommandHandler
    public MeetingAggregate(CreateMeetingCommand createMeetingCommand){
        MeetingCreatedEvent meetingCreatedEvent = new MeetingCreatedEvent();
        BeanUtils.copyProperties(createMeetingCommand,meetingCreatedEvent);
        AggregateLifecycle.apply(meetingCreatedEvent);
    }

    @EventSourcingHandler
    public void on(MeetingCreatedEvent meetingCreatedEvent){
        this.meet_id = meetingCreatedEvent.getMeet_id();
        this.meet_date = meetingCreatedEvent.getMeet_date();
        this.role = meetingCreatedEvent.getRole();
        this.meet_title = meetingCreatedEvent.getMeet_title();
        this.meet_description = meetingCreatedEvent.getMeet_description();
        this.created_by = meetingCreatedEvent.getCreated_by();
    }
}
