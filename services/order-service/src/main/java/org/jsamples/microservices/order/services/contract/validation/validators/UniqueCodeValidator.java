package org.jsamples.microservices.order.services.contract.validation.validators;

import org.jsamples.microservices.order.services.datasource.OrderRepository;
import org.jsamples.microservices.order.services.contract.validation.constraints.UniqueCode;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCodeValidator implements ConstraintValidator<UniqueCode, String> {
    private @Autowired OrderRepository orderRepository;

    @Override
    public void initialize(UniqueCode annotation) {}

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        return !orderRepository.existCode(code);
    }
}
