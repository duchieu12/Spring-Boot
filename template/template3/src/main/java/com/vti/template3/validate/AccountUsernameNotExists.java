package com.vti.template3.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AccountUsernameNotExistsValidator.class)
public @interface AccountUsernameNotExists {
    String message() default "Username exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
