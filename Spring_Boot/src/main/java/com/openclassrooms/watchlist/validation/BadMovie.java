package com.openclassrooms.watchlist.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BadMovieValidator.class)
public @interface BadMovie {
	
	String message() default "If a movie is as bad or worse than 6, write at least 15 characters in the comment section";
	
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}