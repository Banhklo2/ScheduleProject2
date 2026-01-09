package com.example.scheduleproject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleProject2Application {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleProject2Application.class, args);
    }

}
