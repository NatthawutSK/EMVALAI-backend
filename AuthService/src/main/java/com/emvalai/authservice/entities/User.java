package com.emvalai.authservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String _id;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String dob;
    private String gender;
    private String password;
    private String role;
    private String position;
    private String image;
    private String hireDate;
}
