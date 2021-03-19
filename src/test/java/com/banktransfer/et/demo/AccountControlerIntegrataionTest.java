package com.banktransfer.et.demo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest
@AutoConfigureTestDatabase // use h2 database for temporay
// this class perform intergration testinng
public class AccountControlerIntegrataionTest {
     @Autowired
     MockMvc  mvc;

    public void shouldCreateAccountAndAccountAndReturnCreatedAccount()
    {
           // mvc.perform()
           // mvc.perform(post("/api"))


    }

}
