package com.jorgehernandezramirez.spring.springboot.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("local")
@Service
public class ProfileLocalPropertiesImpl extends PropertiesImpl{

    public ProfileLocalPropertiesImpl(){
        //Para Spring
    }
}
