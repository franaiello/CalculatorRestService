package hello;

public class Calculator {

    private final String num1;
    private final String num2;
    private static final String template = "The answer = , %s!";

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
}
