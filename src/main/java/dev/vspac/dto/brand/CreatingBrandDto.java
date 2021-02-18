package dev.vspac.dto.brand;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableCreatingBrandDto.class)
public interface CreatingBrandDto {
	String getName();

	String getCountry();

	String getManagerName();
}
