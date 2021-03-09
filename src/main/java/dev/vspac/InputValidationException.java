package dev.vspac;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputValidationException
		extends RuntimeException implements GraphQLError {

	private static final long serialVersionUID = 1L;
	private final HashMap<String, Object> extensions;

	public InputValidationException(Map<String, String> message) {
		super("Validation Error");
		extensions = new HashMap<String, Object>();
		extensions.putAll(message);
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		return null;
	}

	@Override
	public Map<String, Object> getExtensions() {
		return extensions;
	}

}