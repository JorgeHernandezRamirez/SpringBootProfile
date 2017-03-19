package com.jorgehernandezramirez.spring.springboot.profile.controller;

import com.jorgehernandezramirez.spring.springboot.profile.service.IProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Autowired
    private IProperties properties;

    public PropertyController(){
        //For Spring
    }

    @RequestMapping(value = "/mongodb/url")
    public String getPropertyMongoDbUrl() {
        return properties.getPropertyMongoDbUrl();
    }

    @RequestMapping(value = "/mongodb/version")
    public String getPropertyMongoDbVersion() {
        return properties.getPropertyMongoDbVersion();
    }
}