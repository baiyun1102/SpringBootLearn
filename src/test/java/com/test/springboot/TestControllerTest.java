package com.test.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.test.springboot.controller.TestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
    }
    @Test
    public void getHello() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/helloworld").accept(MediaType.APPLICATION_JSON_UTF8))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(MockMvcResultHandlers.print())
	                .andReturn();
    }
	
    
    @Test
    public void getHelloworl4() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON_UTF8))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(MockMvcResultHandlers.print())
	                .andReturn();
    }
}