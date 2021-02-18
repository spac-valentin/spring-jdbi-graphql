package dev.vspac.exceptions.service;

public class BrandAlreadyExistsException extends RuntimeException {

	public BrandAlreadyExistsException(String brandName) {
		super(String.format("Brand with name: %s already exists", brandName));
	}
}
