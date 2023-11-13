package com.emvalai.leaveservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Collation("leave")
public class LeaveInfoModel {
    @Id
    private String leave_id;
    private String emp_id;
    private String leave_type;
    private String start_date;
    private String end_date;
    private int num_date;
    private boolean leave_status;
    private String evidence_img;
    private String note;
}
