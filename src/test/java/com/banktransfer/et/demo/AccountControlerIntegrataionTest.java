package com.banktransfer.et.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase // use h2 database for temporay
// this class perform intergration testinng
public class AccountControlerIntegrataionTest {
     @Autowired
     MockMvc  mvc;
    @Test
    public void shouldCreateAccountAndReturnTheCreatedAccount() throws Exception {

        mvc.perform(
                post("/api/account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"firstName\": \"sample\",\n" +
                                "    \"lastName\": \"sample\",\n" +
                                "    \"email\": \"fedlu@gmail.com\",\n" +
                                "    \"phoneNumber\": \"+251910108943\",\n" +
                                "    \"pin\": 1011" +
                                "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void shouldReturnAnErrorWhenCreatingAccountWithDuplicateData() throws Exception {

        String data = "{" +
                "  \"firstName\": \"Fedlu   \"," +
                "  \"lastName\": \"Hussien\"," +
                "  \"email\" : \"abuesmael@gmail.com\"," +
                "}";

        mvc.perform(
                post("/api/account/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        // Here we are using the Account object defined in the above 'data' JSON
                        .content(data)
        )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
