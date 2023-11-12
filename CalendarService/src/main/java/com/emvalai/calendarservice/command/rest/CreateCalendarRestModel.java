package com.emvalai.calendarservice.command.rest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCalendarRestModel {
    private String userId;
    private  String title;
    private  String start;
    private  String end;
    private  String allDay;
    private  String desc;
}
