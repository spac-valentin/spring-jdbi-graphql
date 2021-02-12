package dev.vspac.handlers.vehicle;

import com.coxautodev.graphql.tools.GraphQLResolver;
import dev.vspac.AppGraphQLException;
import dev.vspac.domain.Brand;
import dev.vspac.domain.Vehicle;
import dev.vspac.service.BrandService;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleResolver implements GraphQLResolver<Vehicle> {
	private final BrandService brandService;

	@Autowired
	public VehicleResolver(BrandService brandService) {
		this.brandService = brandService;
	}

	public Brand brand(Vehicle vehicle) {
		return brandService.byId(vehicle.brandId())
				.orElseThrow(() -> new AppGraphQLException("Could not find brand with id " + vehicle.brandId()));
	}

	public String someDerivedField(Vehicle vehicle) {
		return "derived" + Instant.now().toString();
	}
}
