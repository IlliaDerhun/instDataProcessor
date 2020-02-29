package com.github.watchyouss.instDataProcessor.integration;

import com.github.watchyouss.instDataProcessor.dto.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static com.github.watchyouss.instDataProcessor.common.CommonConstants.LOCALHOST_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonSearchControllerIntegrationTest {

    private static final String PERSON_NAME_TO_FIND_BY = "John";

    private static final Person EXPECTED_PERSON = new Person(PERSON_NAME_TO_FIND_BY);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private URL base;

    @BeforeEach
    void setUp() throws MalformedURLException {
        this.base = new URL(LOCALHOST_URL.getValue() + port + "/search/person/" + EXPECTED_PERSON.getFirstName());
    }

    @Test
    void findPersonByName() {
        ResponseEntity<Person> personResponseEntity = testRestTemplate.getForEntity(base.toString(), Person.class);
        assertThat(personResponseEntity.getBody(), is(EXPECTED_PERSON));
    }
}
