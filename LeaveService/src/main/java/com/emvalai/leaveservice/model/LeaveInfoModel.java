package com.emvalai.leaveservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class LeaveInfoModel {
    @Id
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
