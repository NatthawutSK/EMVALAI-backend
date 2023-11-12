package com.emvalai.calendarservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateCalendarCommand {
    @TargetAggregateIdentifier
    private final String calendarId;
    private final String title;
    private final String start;
    private final String end;
    private final String allDay;
    private final String desc;


}
