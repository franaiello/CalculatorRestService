package com.aiello.calculator;

import com.aiello.calculator.exception.DivideByZeroException;
import com.aiello.calculator.pojo.Answer;
import com.aiello.calculator.pojo.FormInputs;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public Answer add(FormInputs formInputs) throws NumberFormatException {
        Integer answer = formInputs.getParsedNum1() + formInputs.getParsedNum2();
        return getAnswer(formInputs, answer);
    }

    public Answer subtract(FormInputs formInputs) throws NumberFormatException {
        Integer answer = formInputs.getParsedNum1() - formInputs.getParsedNum2();
        return getAnswer(formInputs, answer);
    }

    public Answer multiply(FormInputs formInputs) throws NumberFormatException {
        Integer answer = formInputs.getParsedNum1() * formInputs.getParsedNum2();
        return getAnswer(formInputs, answer);
    }

    public Answer divide(FormInputs formInputs) throws DivideByZeroException, NumberFormatException {
        if (formInputs.getOperand2().equals("0"))
            throw new DivideByZeroException("num2 is zero - cannot divide by a value of zero");

        Integer answer = formInputs.getParsedNum1() / formInputs.getParsedNum2();
        return getAnswer(formInputs, answer);
    }

    private Answer getAnswer(FormInputs formInputs, Integer answer) {
        Answer instance = new Answer();
        instance.setAnswer(answer.toString());
        instance.setOperand1(formInputs.getOperand1());
        instance.setOperand2(formInputs.getOperand2());
        return instance;
    }
}
