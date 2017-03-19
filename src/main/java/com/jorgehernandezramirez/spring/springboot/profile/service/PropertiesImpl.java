package com.jorgehernandezramirez.spring.springboot.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Profile("!local")
@Service
public class PropertiesImpl implements IProperties{

    @Value("${mongodb.url}")
    private String mongoDBUrl;

    @Value("${mongodb.version}")
    private String mongodbVersion;

    public PropertiesImpl(){
        //Para Spring
    }

    @Override
    public String getPropertyMongoDbUrl() {
        return mongoDBUrl;
    }

    @Override
    public String getPropertyMongoDbVersion() {
        return mongodbVersion;
    }
}
