package dev.vspac.dto.brand;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableAddBrandDto.class)
public interface AddBrandDto {
	String name();
	String country();
}
