package com.aiello.calculator;

public class Answer {
    private final String answer;
    private String operand1;
    private String operand2;

    public Answer(String operand1, String operand2, String answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.answer = answer;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }
}
