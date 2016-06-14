package com.aiello.calculator.controller;

import com.aiello.calculator.Answer;
import com.aiello.calculator.Calculator;
import com.aiello.calculator.FormInputs;
import com.aiello.calculator.exception.CustomGenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    Calculator calc;

    @RequestMapping(value="/entryform", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("formInputs", new FormInputs());
        return "entryform";
    }

    @RequestMapping(value="/entryform", method = RequestMethod.POST)
    public String addSubmit(@ModelAttribute @Valid FormInputs formInputs, Model model, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "entryform";
        }

        validateOperands(formInputs);

        switch (formInputs.getOperator()) {
            case "add":
                Answer answerAdd = calc.add(formInputs);
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

    /**
     * Method validates the operands that were passed in prior to performing any mathematics
     * @param formInputs
     * @throws Exception
     */
    private void validateOperands(@ModelAttribute @Valid FormInputs formInputs) throws Exception {
        try {
            formInputs.getNum1();
            formInputs.getNum2();
        } catch (NumberFormatException nfe) {
            throw new CustomGenericException("Operand(s) is not a numeric value", nfe.getMessage());
        }
    }

    @ExceptionHandler(CustomGenericException.class)
    public ModelAndView handleCustomException(HttpServletRequest req, CustomGenericException cge) {
        logger.error("Requested URL=" + req.getRequestURL());
        logger.error("Exception Raised" + cge);

        ModelAndView model = new ModelAndView("error");
        model.addObject("errCode", cge.getErrCode());
        model.addObject("errMsg", cge.getErrMsg());
        model.addObject("operand1", req.getParameter("operand1"));
        model.addObject("operand2", req.getParameter("operand2"));
        return model;
    }
}
