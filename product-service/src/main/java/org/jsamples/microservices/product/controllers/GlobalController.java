package org.jsamples.microservices.product.controllers;

import org.jsamples.microservices.seedwork.vo.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public GlobalController() {}

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleException(Exception ex) {
        if (ex instanceof IllegalArgumentException) {
            return ResponseEntity.badRequest().body(Error.of("E001", ex.getMessage()));
        }
        if (ex instanceof IndexOutOfBoundsException) {
            return ResponseEntity.notFound().build();
        }
        logger.error("Unexpected exception when procesing a request", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Error.of("E002", ex.getMessage()));
    }
}
