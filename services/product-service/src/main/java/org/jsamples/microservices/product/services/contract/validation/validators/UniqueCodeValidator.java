package org.jsamples.microservices.product.services.contract.validation.validators;

import org.jsamples.microservices.product.services.contract.validation.constraints.UniqueCode;
import org.jsamples.microservices.product.services.datasource.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCodeValidator implements ConstraintValidator<UniqueCode, String> {
    private @Autowired ProductRepository productRepository;

    @Override
    public void initialize(UniqueCode annotation) {
        //Do nothing
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        return !productRepository.existCode(code);
    }
}
