package dev.vspac.dto.vehicle;

import lombok.Value;

@Value
public class CreatingVehicleDto {
	String modelCode;

	String color;

	Long brandId;
}
