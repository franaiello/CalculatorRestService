package com.aiello.calculator;

import com.aiello.calculator.exception.DivideByZeroException;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public Answer add(FormInputs formInputs) throws NumberFormatException {
        Integer answer = formInputs.getNum1() + formInputs.getNum2();
        return new Answer(formInputs.getOperand1(), formInputs.getOperand2(), answer.toString());
    }

    // TODO: Refactor to align with 'add()' method
    public Answer subtract(String num1, String num2) throws NumberFormatException {
        Integer answer = Integer.parseInt(num1) - Integer.parseInt(num2);
        return new Answer(num1, num2, answer.toString());
    }

    // TODO: Refactor to align with 'add()' method
    public Answer multiply(String num1, String num2) throws NumberFormatException {
        Integer answer = Integer.parseInt(num1) * Integer.parseInt(num2);
        return new Answer(num1, num2, answer.toString());
    }

    // TODO: Refactor to align with 'add()' method
    public Answer divide(String num1, String num2) throws DivideByZeroException, NumberFormatException {
        if (num2.equals("0"))
            throw new DivideByZeroException("num2 is zero - cannot divide by a value of zero");

        Integer answer = Integer.parseInt(num1) / Integer.parseInt(num2);
        return new Answer(num1, num2, answer.toString());
    }

}
