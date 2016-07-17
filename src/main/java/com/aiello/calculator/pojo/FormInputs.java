package com.aiello.calculator.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The purpose of this class is to manage the inputs from the form submission
 * as well as passing back data for displaying to end user
 */
@Data
public class FormInputs {

    @NotNull
    @Size(min=1, max=5)
    private String operand1=null;

    @NotNull
    @Size(min=1, max=5)
    private String operand2=null;

    private Integer num1=null;
    private Integer num2=null;

    private String operator;

    public Integer getParsedNum1() throws NumberFormatException {
        return Integer.parseInt(operand1);
    }

    public int getParsedNum2() throws NumberFormatException {
        return Integer.parseInt(operand2);
    }
}
