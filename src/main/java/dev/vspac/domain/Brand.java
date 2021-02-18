package dev.vspac.domain;

import javax.annotation.Nullable;
import org.immutables.value.Value;

@Value.Immutable
public interface Brand {
	@Nullable
	Long getId();

	String getName();

	String getCountry();

	String getManagerName();
}
