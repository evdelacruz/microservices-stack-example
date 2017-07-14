package org.jsamples.microservices.config.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.status;

/**
 * ...
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

    @Override
    public String getErrorPath() {
        return "/error/500";
    }

    @RequestMapping(value="/error/{code}")
    public ResponseEntity<String> error(@PathVariable(required=false) int code) {
        switch (code) {
            case 401:
                return status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
            case 403:
                return status(HttpStatus.FORBIDDEN).body("FORBIDDEN");
            case 404:
                return notFound().build();
            default://500
                return status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL SERVER ERROR");
        }
    }
}
