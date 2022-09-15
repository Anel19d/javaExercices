package com.demo.exercises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ExercisesApplication {

    public static void main(String [] args){
        SpringApplication.run(ExercisesApplication.class);
        System.out.println("Hello word");
    }
}
