package com.yourcompany.invoicing.annotations;

import java.lang.annotation.*;
import jakarta.validation.*;
import com.yourcompany.invoicing.validators.*;

@Constraint(validatedBy=CedulaValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Cedula {
    String message() default "Cédula ecuatoriana no válida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}