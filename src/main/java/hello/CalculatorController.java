package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private static final String template = "You entered, %s";

    @RequestMapping("/calculator")
    public Answer calculator(@RequestParam(value="num1") String num1,
                                 @RequestParam(value="num2") String num2) {
        Calculator calc = new Calculator(num1, num2);
        return calc.add();
    }
}
