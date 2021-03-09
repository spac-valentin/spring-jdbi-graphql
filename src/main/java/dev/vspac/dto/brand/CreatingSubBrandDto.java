package dev.vspac.dto.brand;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.validation.constraints.NotEmpty;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableCreatingSubBrandDto.class)
public interface CreatingSubBrandDto {
	@NotEmpty
	String getName();

	@NotEmpty
	String getCountry();

	@NotEmpty
	String getSubBrandOf();
}
