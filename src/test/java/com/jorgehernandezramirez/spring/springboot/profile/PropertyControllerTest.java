package com.jorgehernandezramirez.spring.springboot.profile;

import com.jorgehernandezramirez.spring.springboot.profile.controller.PropertyController;
import com.jorgehernandezramirez.spring.springboot.profile.service.ProfileLocalPropertiesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PropertyController.class)
public class PropertyControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProfileLocalPropertiesImpl profileLocalProperties;

    @Before
    public void initialization(){
        given(profileLocalProperties.getPropertyMongoDbUrl()).willReturn("localmongodburl_mock");
    }

    @Test
    public void debeDevolverLaUrlDeMongoDB() throws Exception {
        assertEquals("localmongodburl_mock", profileLocalProperties.getPropertyMongoDbUrl());
    }

    @Test
    public void shouldReturnMongoDBUrlFromLocalProfile() throws Exception {
        this.mvc.perform(get("/mongodb/url")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("localmongodburl_mock"));
    }
}
