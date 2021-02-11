package dev.vspac.dto.vehicle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableVehicleDto.class)
public interface VehicleDto {
	Long id();
	String modelCode();
	Long brandId();
}
