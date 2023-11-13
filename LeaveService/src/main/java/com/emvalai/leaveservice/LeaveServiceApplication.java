package com.emvalai.leaveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
public class LeaveServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeaveServiceApplication.class, args);
    }

}
