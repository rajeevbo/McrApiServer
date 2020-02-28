package com.interview.mcr.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ParserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_lineOne_badinput() throws Exception {
        this.mockMvc.perform(get("/lineOne/xxx")).andExpect(status().is4xxClientError());
    }

    @Test
    void test_lineOne_goodinput() throws Exception {
        this.mockMvc.perform(get("/lineOne/P<USAROGGER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"type\":\"P\",\"country\":\"USA\",\"surname\":\"ROGGER\",\"givenName\":null}"));
    }


}