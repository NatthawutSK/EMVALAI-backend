package com.emvalai.userservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "leave")
public class LeaveEntity {
    private int leave_id;
    private String emp_id;
    private String leave_type;
    private String start_date;
    private String end_date;
    private int num_date;
    private boolean leave_status;
    private String evidence_img;
    private String note;
}
