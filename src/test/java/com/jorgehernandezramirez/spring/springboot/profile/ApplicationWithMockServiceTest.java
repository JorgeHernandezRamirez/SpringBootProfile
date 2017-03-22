package com.jorgehernandezramirez.spring.springboot.profile;

import com.jorgehernandezramirez.spring.springboot.profile.service.ProfileLocalPropertiesImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

//@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
public class ApplicationWithMockServiceTest {

    @Autowired
    private TestRestTemplate template;

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
        final String urlMongoDB = template.getForEntity("/mongodb/url", String.class).getBody();
        assertEquals("localmongodburl_mock", urlMongoDB);
    }
}
