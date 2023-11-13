package com.emvalai.calendarservice.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String _id;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String dob;
    private String gender;
    private String role;
    private String position;
    private String image;
    private String hireDate;
    private String password;
}
