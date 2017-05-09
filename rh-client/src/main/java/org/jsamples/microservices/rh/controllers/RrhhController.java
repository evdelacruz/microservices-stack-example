package org.jsamples.microservices.rh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Controlador <b>REST</b> para operaciones artim&eacute;ticas.
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
@RestController("/rrhh/")
public class RrhhController {
    private @Autowired RestTemplate restTemplate;
    private String serviceURL = "http://CALCULATOR-CLIENT/";

    public RrhhController() {}

    @RequestMapping(value="/resources", method=RequestMethod.POST)
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @RequestMapping(value="/multiply", method=RequestMethod.POST)
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
}
