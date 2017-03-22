package com.jorgehernandezramirez.spring.springboot.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
public class ApplicationTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void shouldReturnMongoDBUrlFromLocalProfile() throws Exception {
        final String urlMongoDB = template.getForEntity("/mongodb/url", String.class).getBody();
        assertEquals("localmongodburl", urlMongoDB);
    }
}
