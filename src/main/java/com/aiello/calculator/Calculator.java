package com.aiello.calculator;

import com.aiello.calculator.exception.DivideByZeroException;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public Answer add(FormInputs formInputs) throws NumberFormatException {
        Integer answer = formInputs.getNum1() + formInputs.getNum2();
        return new Answer(formInputs.getOperand1(), formInputs.getOperand2(), answer.toString());
    }

    public Answer subtract(FormInputs formInputs) throws NumberFormatException {
        Integer answer = formInputs.getNum1() - formInputs.getNum2();
        return new Answer(formInputs.getOperand1(), formInputs.getOperand2(), answer.toString());
    }

    public Answer multiply(FormInputs formInputs) throws NumberFormatException {
        Integer answer = formInputs.getNum1() * formInputs.getNum2();
        return new Answer(formInputs.getOperand1(), formInputs.getOperand2(), answer.toString());
    }

    public Answer divide(FormInputs formInputs) throws DivideByZeroException, NumberFormatException {
        if (formInputs.getOperand2().equals("0"))
            throw new DivideByZeroException("num2 is zero - cannot divide by a value of zero");

        Integer answer = formInputs.getNum1() / formInputs.getNum2();
        return new Answer(formInputs.getOperand1(), formInputs.getOperand2(), answer.toString());
    }

}
