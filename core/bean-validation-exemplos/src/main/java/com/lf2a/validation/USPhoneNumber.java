package com.lf2a.validation;

/**
 * <h1>USPhoneNumber.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 10/03/2021
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Pattern.List({})
/* A number of format "+1-NNN-NNN-NNNN" */
@Pattern(regexp = "\\+1-\\d{3}-\\d{3}-\\d{4}")
@Constraint(validatedBy = {})
@Documented
@Target({ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(USPhoneNumber.List.class)
public @interface USPhoneNumber {

    String message() default "Not a valid US Phone Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({ElementType.METHOD,
            ElementType.FIELD,
            ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR,
            ElementType.PARAMETER,
            ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        USPhoneNumber[] value();
    }
}