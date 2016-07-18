package com.aiello.calculator;

import com.aiello.calculator.pojo.Answer;
import com.aiello.calculator.pojo.FormInputs;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class CalculatorControllerIT {
    private MockMvc mockMvc;
    private static final String PATH = "/entryform";
    private FormInputs formInputs;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void add() throws Exception {
        formInputs = new FormInputs();
        formInputs.setOperand1("2");
        formInputs.setOperand2("3");
        formInputs.setOperator("add");

        mockMvc.perform(post(PATH)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("operand1", formInputs.getOperand1())
                .param("operand2", formInputs.getOperand2())
                .param("operator", formInputs.getOperator())
                .sessionAttr("formInputs", formInputs)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("result"))
                .andExpect(model().attribute("result", "Answer(answer=5, operand1=2, operand2=3)"))
                .andReturn();
    }

    @Ignore
    @Test
    public void subtract() throws Exception {
        mockMvc.perform(get("/subtract?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("answer=", is("3")));
    }

    @Ignore
    @Test
    public void multiply() throws Exception {
        mockMvc.perform(get("/multiply?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("18")));
    }

    @Ignore
    @Test
    public void divide() throws Exception {
        mockMvc.perform(get("/divide?num1=6&num2=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.num1", is("6")))
                .andExpect(jsonPath("$.num2", is("3")))
                .andExpect(jsonPath("$.answer", is("2")));
    }

    @Ignore
    @Test
    public void divideByZero() throws Exception {
        mockMvc.perform(get("/divide?num1=6&num2=0"))
                .andExpect(status().isConflict());
    }

}
