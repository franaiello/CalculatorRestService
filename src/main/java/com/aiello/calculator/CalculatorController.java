package com.aiello.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @Autowired Calculator calc;

    @RequestMapping(value="/entryform", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("formInputs", new FormInputs());
        return "entryform";
    }

    @RequestMapping(value="/entryform", method = RequestMethod.POST)
    public String addSubmit(@ModelAttribute FormInputs formInputs, Model model) {
        switch (formInputs.getOperator()) {
            case "add":
                Answer answerAdd = calc.add(formInputs.getOperand1(), formInputs.getOperand2());
                model.addAttribute("result", answerAdd);
                break;
            case "subtract":
                Answer answerSubtract = calc.subtract(formInputs.getOperand1(), formInputs.getOperand2());
                model.addAttribute("result", answerSubtract);
                break;
            case "multiply":
                Answer answerMultiply = calc.multiply(formInputs.getOperand1(), formInputs.getOperand2());
                model.addAttribute("result", answerMultiply);
                break;
            case "divide":
                Answer answerDivide = calc.divide(formInputs.getOperand1(), formInputs.getOperand2());
                model.addAttribute("result", answerDivide);
                break;
        }

        return "answer";

    }
}
