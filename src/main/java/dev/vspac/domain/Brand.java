package dev.vspac.domain;

import java.beans.ConstructorProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.mapper.reflect.JdbiConstructor;

@Data
@NoArgsConstructor
public class Brand {
	private Long id;
	private String name;
	private String country;

	@JdbiConstructor
	@ConstructorProperties({"id", "name", "country"})
	public Brand(Long id, String name, String country) {
		this.id = id;
		this.name = name;
		this.country = country;
	}
}
