package com.aiello.calculator;

public class Answer {
    private final String answer;
    private final String num1;
    private final String num2;

    public Answer(String num1, String num2, String answer) {
        this.num1 = num1;
        this.num2 = num2;
        this.answer = answer;
    }

    public String getNum1() {
        return num1;
    }

    public String getNum2() {
        return num2;
    }

    public String getAnswer() {
        return this.answer;
    }

}
