package com.emvalai.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user")
public class UserEntity {

    @Id
    private String _id;
    private String fName;
    private String lName;

    @Indexed(unique = true)
    private String email;

    @Indexed(unique = true)
    private String phone;

    private String dob;
    private String gender;
    private String password;
    private String role;
    private String position;
    private String image;
    private String hireDate;

}
