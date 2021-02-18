package dev.vspac.exceptions.graphql;

import dev.vspac.AppGraphQLException;

public class BrandNotFoundException extends AppGraphQLException {
	public BrandNotFoundException(Long id) {
		super(String.format("Brand with ID: %s could not be found", id));
	}

	public BrandNotFoundException(String name) {
		super(String.format("Brand with name: %s could not be found", name));
	}
}
