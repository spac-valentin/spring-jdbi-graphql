package dev.vspac.handlers.vehicle;

import com.coxautodev.graphql.tools.GraphQLResolver;
import dev.vspac.domain.Brand;
import dev.vspac.dto.brand.BrandDto;
import dev.vspac.dto.vehicle.VehicleDto;
import dev.vspac.exceptions.graphql.BrandNotFoundException;
import dev.vspac.mappers.BrandMapper;
import dev.vspac.service.BrandService;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleResolver implements GraphQLResolver<VehicleDto> {
	private final BrandService brandService;
	private final BrandMapper brandMapper;

	@Autowired
	public VehicleResolver(BrandService brandService, BrandMapper brandMapper) {
		this.brandService = brandService;
		this.brandMapper = brandMapper;
	}

	public BrandDto brand(VehicleDto vehicleDto) {
		Long brandId = vehicleDto.getBrandId();
		Brand brand = brandService.byId(brandId)
				.orElseThrow(() -> new BrandNotFoundException(brandId));
		return brandMapper.toBrandDto(brand);
	}

	public String someDerivedField(VehicleDto vehicle) {
		return "derived" + Instant.now().toString();
	}
}
