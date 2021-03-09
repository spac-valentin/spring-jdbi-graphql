package dev.vspac.handlers.vehicle;

import dev.vspac.exceptions.graphql.VehicleNotFoundException;
import dev.vspac.mappers.VehicleMapper;
import dev.vspac.domain.Brand;
import dev.vspac.domain.Vehicle;
import dev.vspac.dto.vehicle.CreatingNoBrandIdVehicleDto;
import dev.vspac.dto.vehicle.CreatingVehicleDto;
import dev.vspac.dto.vehicle.VehicleDto;
import dev.vspac.service.BrandService;
import dev.vspac.service.VehicleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class VehicleMutations implements GraphQLMutationResolver {
	private final VehicleService service;
	private final BrandService brandService;
	private final VehicleMapper vehicleMapper;

	@Autowired
	public VehicleMutations(VehicleService service,
	                        BrandService brandService,
	                        VehicleMapper vehicleMapper) {
		this.service = service;
		this.brandService = brandService;
		this.vehicleMapper = vehicleMapper;
	}

	public VehicleDto addVehicle(@Valid CreatingVehicleDto dto) {
		Vehicle vehicle = vehicleMapper.fromCreatingVehicleDto(dto);
		Vehicle savedVehicle = service.add(vehicle);

		return vehicleMapper.toVehicleDto(savedVehicle);
	}

	public VehicleDto updateVehicle(Long id, @Valid CreatingVehicleDto dto) {
		Vehicle vehicle = vehicleMapper.fromCreatingVehicleDto(dto);
		vehicle.setId(id);

		Vehicle updatedVehicle = service.update(vehicle).orElseThrow(
				() -> new VehicleNotFoundException(id));
		return vehicleMapper.toVehicleDto(updatedVehicle);
	}

	public VehicleDto addVehicleForBrandName(String brandName, @Valid CreatingNoBrandIdVehicleDto dto) {
		Brand brand = brandService.findByName(brandName).orElseThrow(
				() -> new VehicleNotFoundException(brandName));

		Vehicle vehicle = vehicleMapper.fromCreatingNoBrandIdVehicleDto(dto);
		vehicle.setBrandId(brand.getId());
		Vehicle savedVehicle = service.add(vehicle);
		return vehicleMapper.toVehicleDto(savedVehicle);
	}
}
