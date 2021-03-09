package dev.vspac.handlers;

import dev.vspac.InputValidationException;
import graphql.GraphQLError;
import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphQlExceptionHandler {
	@ExceptionHandler(ConstraintViolationException.class)
	public GraphQLError handleConstraintViolationException(ConstraintViolationException e) {
		Map<String, String> extentions = new HashMap<>();
		for (ConstraintViolation contraints : e.getConstraintViolations()) {
			String propertyPath = contraints.getPropertyPath().toString();
			String propertyName = propertyPath.substring(propertyPath.lastIndexOf('.') + 1);
			extentions.put(propertyName, contraints.getMessage());
		}
		return new InputValidationException(extentions);
	}
}
