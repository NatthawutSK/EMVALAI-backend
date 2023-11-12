package com.emvalai.authservice.services;

import com.emvalai.authservice.entities.AuthRequest;
import com.emvalai.authservice.entities.AuthResponse;
import com.emvalai.authservice.entities.User;
import com.emvalai.authservice.entities.UserRestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    private final JwtUtil jwt;

    @Autowired
    public AuthService(final JwtUtil jwt){
        this.jwt = jwt;
    }

    public AuthResponse logIn(AuthRequest authRequest){
        // check login here
       User userDb = new RestTemplate().getForObject("http://localhost:8080/user/login/" + authRequest.getEmail(), User.class);
        if (!authRequest.getPassword().equals(userDb.getPassword())){
//            System.out.println("login fail");
            throw new IllegalArgumentException("login fail");
//            return new AuthResponse("", "", "Login Fail");
        }

        UserRestModel user = UserRestModel.builder()
                ._id(userDb.get_id())
                .email(userDb.getEmail())
                .role(userDb.getRole())
                .fName(userDb.getFName())
                .lName(userDb.getLName())
                .dob(userDb.getDob())
                .gender(userDb.getGender())
                .phone(userDb.getPhone())
                .image(userDb.getImage())
                .hireDate(userDb.getHireDate())
                .position(userDb.getPosition())
                .build();
        System.out.println(user.toString());
        String accessToken = jwt.generate(user, "ACCESS");
        String refreshToken =  jwt.generate(user, "REFRESH");

        return new AuthResponse(accessToken, refreshToken, "Login Success", user);
    }

}
