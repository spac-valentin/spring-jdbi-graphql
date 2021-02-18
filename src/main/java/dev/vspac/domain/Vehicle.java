package dev.vspac.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
  private Long id;

  private Long brandId;

  private String modelCode;

  private String color;
}
