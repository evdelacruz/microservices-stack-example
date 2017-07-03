package org.jsamples.microservices.order.services.contract.validation.constraints;

import org.jsamples.microservices.order.services.contract.validation.validators.UniqueCodeValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy=UniqueCodeValidator.class)
public @interface UniqueCode {

    String message() default "UniqueCode.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
