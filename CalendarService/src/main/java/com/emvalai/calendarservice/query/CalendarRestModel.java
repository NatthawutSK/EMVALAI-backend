package com.emvalai.calendarservice.query;

import lombok.Data;

@Data
public class CalendarRestModel {
    private String _id;
    private  String title;
    private  String start;
    private  String end;
    private  String allDay;
    private  String desc;
}
