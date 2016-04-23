package com.aiello.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    private static final String template = "You entered, %s";

    @Autowired Calculator calc;

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public Answer add(@RequestParam(value="num1") String num1,
                      @RequestParam(value="num2") String num2) {
        return calc.add(num1, num2);
    }

    @RequestMapping(value="/subtract", method = RequestMethod.GET)
    public Answer subtract(@RequestParam(value="num1") String num1,
                           @RequestParam(value="num2") String num2) {
        return calc.subtract(num1, num2);
    }

    @RequestMapping(value="/multiply", method = RequestMethod.GET)
    public Answer multiply(@RequestParam(value="num1") String num1,
                           @RequestParam(value="num2") String num2) {
        return calc.multiply(num1, num2);
    }

    @RequestMapping(value="/divide", method = RequestMethod.GET)
    public Answer divide(@RequestParam(value="num1") String num1,
                         @RequestParam(value="num2") String num2) throws DivideByZeroException {
        return calc.divide(num1, num2);
    }
}
