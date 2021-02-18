package dev.vspac.dto.brand;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableCreatingSubBrandDto.class)
public interface CreatingSubBrandDto {
	String getName();

	String getCountry();

	String getSubBrandOf();
}
