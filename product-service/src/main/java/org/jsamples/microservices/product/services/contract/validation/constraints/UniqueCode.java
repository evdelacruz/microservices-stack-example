package org.jsamples.microservices.product.services.contract.validation.constraints;

import org.jsamples.microservices.product.services.contract.validation.validators.UniqueCodeValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy=UniqueCodeValidator.class)
public @interface UniqueCode {

    String message() default "UniqueCode.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
