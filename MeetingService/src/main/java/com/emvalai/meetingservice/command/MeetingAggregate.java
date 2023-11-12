package com.emvalai.meetingservice.command;

import com.emvalai.meetingservice.core.event.MeetingCreatedEvent;
import com.emvalai.emcore.event.MeetingCreateEvent;
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
        MeetingCreateEvent meetingCreatedEvent = new MeetingCreateEvent();
        BeanUtils.copyProperties(createMeetingCommand,meetingCreatedEvent);
        AggregateLifecycle.apply(meetingCreatedEvent);
    }

    @EventSourcingHandler
    public void on(MeetingCreateEvent meetingCreateEvent){
        this.meet_id = meetingCreateEvent.getMeet_id();
        this.meet_date = meetingCreateEvent.getMeet_date();
        this.role = meetingCreateEvent.getRole();
        this.meet_title = meetingCreateEvent.getMeet_title();
        this.meet_description = meetingCreateEvent.getMeet_description();
        this.created_by = meetingCreateEvent.getCreated_by();
    }
}
