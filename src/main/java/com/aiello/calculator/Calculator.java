package com.aiello.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public Answer add(String num1, String num2) {
        Integer answer = Integer.parseInt(num1) + Integer.parseInt(num2);
        return new Answer(num1, num2, answer.toString());
    }

    public Answer subtract(String num1, String num2) {
        Integer answer = Integer.parseInt(num1) - Integer.parseInt(num2);
        return new Answer(num1, num2, answer.toString());
    }

    public Answer multiply(String num1, String num2) {
        Integer answer = Integer.parseInt(num1) * Integer.parseInt(num2);
        return new Answer(num1, num2, answer.toString());
    }

    public Answer divide(String num1, String num2) throws DivideByZeroException {
        if (num2.equals("0"))
            throw new DivideByZeroException("num2 is zero - cannot divide by a value of zero");

        Integer answer = Integer.parseInt(num1) / Integer.parseInt(num2);
        return new Answer(num1, num2, answer.toString());
    }
}
