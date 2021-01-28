package dev.vspac.domain;

import java.beans.ConstructorProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.mapper.reflect.JdbiConstructor;

@Data
@NoArgsConstructor
public class Vehicle {
	private Long id;
	private Long brandId;
	private String modelCode;
	private String somethingElse;


	@JdbiConstructor
	@ConstructorProperties({"id", "brandId", "modelCode"})
	public Vehicle(Long id, Long brandId, String modelCode) {
		this.id = id;
		this.brandId = brandId;
		this.modelCode = modelCode;
	}
}
