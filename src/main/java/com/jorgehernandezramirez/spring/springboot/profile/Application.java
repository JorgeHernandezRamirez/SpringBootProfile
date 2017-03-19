package com.jorgehernandezramirez.spring.springboot.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public Application(){
        //For Spring
    }

    public static void main(String[] parameters){
        SpringApplication.run(Application.class, parameters);
    }
}
