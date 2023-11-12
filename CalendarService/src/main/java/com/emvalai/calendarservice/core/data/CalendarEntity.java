package com.emvalai.calendarservice.core.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "calendar")
public class CalendarEntity {
    @Id
    private  String _id;
    private  String title;
    private  String start;
    private  String end;
    private  String allDay;
    private  String desc;
    private  String userId;
}
