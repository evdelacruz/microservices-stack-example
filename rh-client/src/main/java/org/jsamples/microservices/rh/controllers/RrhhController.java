package org.jsamples.microservices.calculator.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador <b>REST</b> para operaciones artim&eacute;ticas.
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
@RestController("/arithmetic-operations/")
public class ArithmeticController {

    public ArithmeticController() {}

    @RequestMapping(value="/sum", method=RequestMethod.POST)
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    @RequestMapping(value="/multiply", method=RequestMethod.POST)
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
}
