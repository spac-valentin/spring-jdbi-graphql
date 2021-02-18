package dev.vspac.dto.brand;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableBrandDto.class)
public interface BrandDto{
	Long getId();

	String getName();

	String getCountry();

	String getManagerName();
}
