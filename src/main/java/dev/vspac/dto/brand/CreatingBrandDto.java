package dev.vspac.dto.brand;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.validation.constraints.NotEmpty;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableCreatingBrandDto.class)
public interface CreatingBrandDto {
	@NotEmpty
	String getName();

	@NotEmpty
	String getCountry();

	@NotEmpty
	String getManagerName();
}
