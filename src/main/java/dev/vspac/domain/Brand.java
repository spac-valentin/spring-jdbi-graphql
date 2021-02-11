package dev.vspac.domain;

import javax.annotation.Nullable;
import org.immutables.value.Value;

@Value.Immutable
public interface Brand {
	@Nullable
	Long id();
	String name();
	String country();
}
