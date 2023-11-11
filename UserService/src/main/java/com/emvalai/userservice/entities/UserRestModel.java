package com.emvalai.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRestModel {

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
//    private String status;
}
