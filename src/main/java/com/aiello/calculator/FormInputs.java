package com.aiello.calculator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The purpose of this class is to manage the inputs from the form submission
 */
public class FormInputs {

    @NotNull
    @Size(min=1, max=5)
    private String operand1;

    @NotNull
    @Size(min=1, max=5)
    private String operand2;

    private Integer num1=null;
    private Integer num2=null;

    private String operator;

    public void setOperand1(final String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(final String operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(final String operator) {
        this.operator = operator;
    }

    public Integer getNum1() throws NumberFormatException {
        return Integer.parseInt(operand1);
    }

    public int getNum2() throws NumberFormatException {
        return Integer.parseInt(operand2);
    }
}
