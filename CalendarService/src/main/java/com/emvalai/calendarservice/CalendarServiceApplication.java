package com.emvalai.calendarservice;

import com.emvalai.emcore.event.AxonXstreamConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@Import({AxonXstreamConfig.class})
public class CalendarServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CalendarServiceApplication.class, args);
	}

}
