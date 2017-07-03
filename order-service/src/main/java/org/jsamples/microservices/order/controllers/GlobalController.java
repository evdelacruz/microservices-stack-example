package org.jsamples.microservices.order.controllers;

import org.jsamples.microservices.seedwork.binding.vo.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public GlobalController() {}

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleException(Exception ex) {
        if (ex instanceof IllegalArgumentException) {
            return ResponseEntity.notFound().build();
        }
        if (ex instanceof MethodArgumentNotValidException) {
            String fields = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors().stream()
                    .map(FieldError::getField)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(Error.of("E01", "Invalid fields: "+fields));
        }
        logger.error("Unexpected exception when procesing a request", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Error.of("E002", ex.getMessage()));
    }
}
