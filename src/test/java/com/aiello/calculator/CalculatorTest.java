package com.aiello.calculator;

import com.aiello.calculator.exception.DivideByZeroException;
import mockit.*;

import static mockit.Deencapsulation.invoke;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


public class CalculatorTest {

    private static final String OPERAND_ONE = "2";
    private static final String OPERAND_TWO = "3";

    @Tested Calculator tested;
    @Mocked FormInputs formInputs;

    @BeforeMethod
    public void setUp() throws Exception {
        formInputs = new FormInputs();
        formInputs.setOperand1(OPERAND_ONE);
        formInputs.setOperand2(OPERAND_TWO);
    }


    @Test
    public void testAdd() throws Exception {
        new Expectations() {{
            formInputs.getNum1(); result = 2;
            formInputs.getNum2(); result = 3;
        }};
        assertThat(tested.add(formInputs)).isInstanceOf(Answer.class);
    }

    @Test
    public void testSubtract() throws Exception {
        new Expectations() {{
            formInputs.getNum1(); result = 5;
            formInputs.getNum2(); result = 3;
        }};
        assertThat(tested.subtract(formInputs)).isInstanceOf(Answer.class);
    }

    @Test
    public void testMultiply() throws Exception {
        assertThat(tested.multiply(formInputs)).isInstanceOf(Answer.class);
    }

    @Test
    public void testDivide(@Mocked final FormInputs inputs) throws Exception {
        new Expectations(tested) {{
            Integer val1=10;
            Integer val2=5;
            Integer divideResult = 0;

            inputs.getOperand2(); result = 5;
            inputs.getNum1(); result = 10;
            inputs.getNum2(); result = 5;
            divideResult = val1 / val2; result = 2;
        }};

        assertThat(tested.divide(inputs)).isInstanceOf(Answer.class);
    }

    @Test (expectedExceptions = DivideByZeroException.class,
            description = "Test method validates a divide by zero")
    public void testDivideByZero(@Mocked final FormInputs inputs) throws Exception {
        new Expectations() {{
            inputs.getOperand2(); result = "0";
        }};

        invoke(tested, "divide", inputs);
    }

}
