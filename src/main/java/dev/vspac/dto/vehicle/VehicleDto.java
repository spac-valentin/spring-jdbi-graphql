package dev.vspac.dto.vehicle;

import lombok.Value;

@Value
public class VehicleDto {
	Long id;

	Long brandId;

	String modelCode;

	String color;
}
