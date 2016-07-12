package com.aiello.calculator;

import lombok.Data;

/**
 * Class is a simple POJO that is serialized to HTML page
 */
@Data
public class Answer {
    private final String answer;
    private String operand1;
    private String operand2;

    public Answer(String operand1, String operand2, String answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.answer = answer;
    }
}
