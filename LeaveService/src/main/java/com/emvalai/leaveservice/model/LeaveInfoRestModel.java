package com.emvalai.leaveservice.model;

//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveInfoRestModel {
    @Id
    private String leave_id;
    private String emp_id;
    private String leave_type;
    private String start_date;
    private String end_date;
    private boolean leave_status;
    private String firstName;
    private String lastName;
    private String role;

}
