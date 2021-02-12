package dev.vspac.domain;

import org.immutables.value.Value;

@Value.Immutable
public interface Vehicle {

  Long id();

  Long brandId();

  String modelCode();

  String somethingElse();
}
