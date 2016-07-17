package com.aiello.calculator;

import com.aiello.calculator.exception.DivideByZeroException;
import com.aiello.calculator.pojo.Answer;
import com.aiello.calculator.pojo.FormInputs;
import mockit.*;

import static mockit.Deencapsulation.invoke;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

@Test(groups = "unit")
public class CalculatorTest {

    @Tested Calculator tested;
    @Mocked FormInputs formInputs;
    @Mocked Answer answer;

    @BeforeMethod
    public void setUp() throws Exception {
        new NonStrictExpectations() {{
            formInputs.getParsedNum1(); result = 6;
            formInputs.getParsedNum2(); result = 0;
            formInputs.getOperand1(); result = 6;
            formInputs.getOperand2(); result = 0;
        }};
    }

    @Test
    public void testAdd() throws Exception {
        assertThat(tested.add(formInputs)).isInstanceOf(Answer.class);
    }

    @Test
    public void testSubtract() throws Exception {
        assertThat(tested.subtract(formInputs)).isInstanceOf(Answer.class);
    }

    @Test
    public void testMultiply() throws Exception {
        assertThat(tested.multiply(formInputs)).isInstanceOf(Answer.class);
    }

    @Test
    public void testDivide(@Mocked final FormInputs inputs) throws Exception {
        new Expectations(tested) {{
            inputs.getOperand2(); result = 5;
            inputs.getParsedNum1(); result = 10;
            inputs.getParsedNum2(); result = 5;
        }};

        assertThat(tested.divide(inputs)).isInstanceOf(Answer.class);
    }

    @Test (expectedExceptions = DivideByZeroException.class,
            description = "Test method validates a divide by zero")
    public void testDivideByZero(@Mocked final FormInputs inputs) throws Exception {
        invoke(tested, "divide", inputs);
    }

}
