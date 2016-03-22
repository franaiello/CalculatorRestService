package com.aiello.calculator;

public class Calculator {

    private final String num1;
    private final String num2;

    public Calculator(String num1, String num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public String getNum1() {
        return num1;
    }

    public String getNum2() {
        return num2;
    }

    public Answer add() {
        Integer answer = Integer.parseInt(this.num1) + Integer.parseInt(this.num2);
        return new Answer(num1, num2, answer.toString());
    }

    public Answer subtract() {
        Integer answer = Integer.parseInt(this.num1) - Integer.parseInt(this.num2);
        return new Answer(num1, num2, answer.toString());
    }

    public Answer multiply() {
        Integer answer = Integer.parseInt(this.num1) * Integer.parseInt(this.num2);
        return new Answer(num1, num2, answer.toString());
    }

    public Answer divide() throws DivideByZeroException {
        if (num2.equals("0"))
            throw new DivideByZeroException("num2 is zero - cannot divide by a value of zero");

        Integer answer = Integer.parseInt(this.num1) / Integer.parseInt(this.num2);
        return new Answer(num1, num2, answer.toString());
    }
}