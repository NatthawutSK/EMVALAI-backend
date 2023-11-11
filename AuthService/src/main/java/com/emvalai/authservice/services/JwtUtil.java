package com.emvalai.authservice.services;

import com.emvalai.authservice.entities.User;
import com.emvalai.authservice.entities.UserRestModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expirationTime;

    private Key key;

    @PostConstruct
    public void init(){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Claims getAllClaimsFromTokenToken(String token){
        return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public Date getExpirationDateFromToken(String token){
        return getAllClaimsFromTokenToken(token).getExpiration();
    }

    public Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generate(UserRestModel user, String type){
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.get_id());
        claims.put("role", user.getRole());
        claims.put("email", user.getEmail());
        claims.put("fName", user.getFName());
        claims.put("lName", user.getLName());
        claims.put("gender", user.getGender());
        claims.put("dob", user.getDob());
        claims.put("phone", user.getPhone());
        claims.put("image", user.getImage());
        claims.put("position", user.getPosition());
        claims.put("hireDate", user.getHireDate());
        return doGenerateToken(claims, user.getEmail(), type);

    }

    public String doGenerateToken(Map<String, Object> claims, String email, String type){
        long expirationTimeLong;
        if ("ACCESS".equals(type)){
            expirationTimeLong = Long.parseLong(expirationTime) * 1000;
        } else {
            expirationTimeLong = Long.parseLong(expirationTime) * 1000 * 5;
        }
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public Boolean validateToken(String token){
        return !isTokenExpired(token);
    }

}
