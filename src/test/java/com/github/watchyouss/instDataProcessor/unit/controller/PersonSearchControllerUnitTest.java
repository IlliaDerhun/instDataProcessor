package com.github.watchyouss.instDataProcessor.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.watchyouss.instDataProcessor.dto.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Junit tests for {@link PersonSearchController}
 */
@SpringBootTest
@AutoConfigureMockMvc
class PersonSearchControllerUnitTest {

    private static final String PERSON_NAME_TO_FIND_BY = "John";

    private static final Person EXPECTED_PERSON = new Person(PERSON_NAME_TO_FIND_BY);

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private JacksonTester<Person> json;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    void findPersonByName() throws Exception {
        String expectedJsonResponseBody = json.write(EXPECTED_PERSON).getJson();
        mvc.perform(MockMvcRequestBuilders.get("/search/person/" + EXPECTED_PERSON.getFirstName())
                                          .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
           .andExpect(content().string(equalTo(expectedJsonResponseBody)));
    }
}
