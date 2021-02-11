package dev.vspac.handlers.vehicle;

import com.coxautodev.graphql.tools.GraphQLResolver;
import dev.vspac.AppGraphQLException;
import dev.vspac.domain.Brand;
import dev.vspac.dto.brand.BrandDto;
import dev.vspac.dto.brand.ImmutableBrandDto;
import dev.vspac.dto.vehicle.VehicleDto;
import dev.vspac.service.BrandService;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleResolver implements GraphQLResolver<VehicleDto> {
	private final BrandService brandService;

	@Autowired
	public VehicleResolver(BrandService brandService) {
		this.brandService = brandService;
	}

	public BrandDto brand(VehicleDto vehicleDto) {
		Brand brand = brandService.byId(vehicleDto.brandId())
				.orElseThrow(() -> new AppGraphQLException("Could not find brand with id " + vehicleDto.brandId()));
		return ImmutableBrandDto.builder()
							 .id(brand.id())
							 .name(brand.name())
							 .country(brand.country())
				       .build();
	}

	public String someDerivedField(VehicleDto vehicle) {
		return "derived" + Instant.now().toString();
	}
}
