package com.emvalai.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditUser {
    private String _id;
    private String fName;
    private String lName;
    private String phone;
    private String email;
    private String dob;
}
