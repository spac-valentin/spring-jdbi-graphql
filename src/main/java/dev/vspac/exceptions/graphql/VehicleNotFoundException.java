package dev.vspac.exceptions.graphql;

import dev.vspac.AppGraphQLException;

public class VehicleNotFoundException extends AppGraphQLException {
	public VehicleNotFoundException(Long id) {
		super(String.format("Vehicle with ID: %s could not be found", id));
	}

	public VehicleNotFoundException(String name) {
		super(String.format("Vehicle with name: %s could not be found", name));
	}
}
