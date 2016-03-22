package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private static final String template = "You entered, %s";

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public Answer add(@RequestParam(value="num1") String num1,
                      @RequestParam(value="num2") String num2) {
        Calculator calc = new Calculator(num1, num2);
        return calc.add();
    }

    @RequestMapping(value="/subtract", method = RequestMethod.GET)
    public Answer subtract(@RequestParam(value="num1") String num1,
                           @RequestParam(value="num2") String num2) {
        Calculator calc = new Calculator(num1, num2);
        return calc.subtract();
    }

    @RequestMapping(value="/multiply", method = RequestMethod.GET)
    public Answer multiply(@RequestParam(value="num1") String num1,
                           @RequestParam(value="num2") String num2) {
        Calculator calc = new Calculator(num1, num2);
        return calc.multiply();
    }

    @RequestMapping(value="/divide", method = RequestMethod.GET)
    public Answer divide(@RequestParam(value="num1") String num1,
                         @RequestParam(value="num2") String num2) {
        Calculator calc = new Calculator(num1, num2);
        return calc.divide();
    }
}
