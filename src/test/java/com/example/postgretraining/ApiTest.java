package com.example.postgretraining;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testAccessToSkatersWithoutToken() throws Exception {
        mvc.perform(get("/skaters"))
                .andExpect(status().isUnauthorized());


    }
    @Test
    void testAccessToHello() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }
    @Test
    void testSkatersWithToken() throws Exception {
        String token = "Bearer mixon69";
        mvc.perform(get("/skaters").header("Authorization" , token))
        .andExpect(status().isOk());
    }

}
