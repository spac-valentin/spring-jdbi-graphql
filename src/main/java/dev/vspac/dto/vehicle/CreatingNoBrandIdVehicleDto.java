package dev.vspac.dto.vehicle;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Value;

@Value
public class CreatingNoBrandIdVehicleDto {
	@NotEmpty
	String modelCode;

	@Size(max = 10)
	String color;
}
