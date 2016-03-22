package com.aiello.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebAppConfiguration
public class CalculatorControllerTest {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(get("/add?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("9")));
    }

    @Test
    public void subtract() throws Exception {
        mockMvc.perform(get("/subtract?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("3")));
    }

    @Test
    public void multiply() throws Exception {
        mockMvc.perform(get("/multiply?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("18")));
    }

    @Test
    public void divide() throws Exception {
        mockMvc.perform(get("/divide?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("2")));
    }
}
