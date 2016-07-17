package com.aiello.calculator.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Class is a simple POJO that is serialized to HTML page
 */
@Data
public class Answer {
    @NotNull
    private String answer=null;

    @NotNull
    private String operand1=null;

    @NotNull
    private String operand2=null;
}
