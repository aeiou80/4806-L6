package com.example.testingweb;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnNewAddressBook() throws Exception {
        this.mockMvc.perform(post("/addressbook")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"buddyInfos\":[],\"size\":0}")));
    }

    @Test
    public void shouldReturnAddressBook() throws Exception {
        this.mockMvc.perform(post("/addressbook")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/addressbook/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"buddyInfos\":[],\"size\":0}")));
    }

    @Test
    public void shouldReturnBuddyGreeting() throws Exception {
        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, buddy")));
    }

}
