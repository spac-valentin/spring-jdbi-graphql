package dev.vspac.dto.vehicle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableAddVehicleDto.class)
public interface AddVehicleDto {
	String modelCode();
	String brandName();
}
