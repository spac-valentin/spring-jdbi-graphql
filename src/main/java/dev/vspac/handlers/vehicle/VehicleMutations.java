package dev.vspac.handlers.vehicle;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import dev.vspac.AppGraphQLException;
import dev.vspac.domain.Brand;
import dev.vspac.domain.ImmutableVehicle;
import dev.vspac.domain.Vehicle;
import dev.vspac.service.BrandService;
import dev.vspac.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutations implements GraphQLMutationResolver {
	private final VehicleService service;
	private final BrandService brandService;

	@Autowired
	public VehicleMutations(VehicleService service, BrandService brandService) {
		this.service = service;
		this.brandService = brandService;
	}

	public Vehicle addVehicle(String modelCode, String brandName) {
		Brand brand = brandService.findByName(brandName)
				              .orElseThrow(() -> this.brandNotFoundException(brandName));

		Vehicle vehicle = ImmutableVehicle.builder()
				                  .brandId(brand.id())
				                  .modelCode(modelCode)
				                  .build();
		Vehicle savedVehicle = service.add(vehicle);

		return ImmutableVehicle.builder()
				       .id(savedVehicle.id())
				       .brandId(savedVehicle.brandId())
				       .modelCode(savedVehicle.modelCode())
				       .build();
	}

	public Vehicle updateVehicle(Vehicle vehicle) {
		Vehicle v = service.byId(vehicle.id())
				.orElseThrow(() -> this.vehicleNotFound(vehicle.id()));

//		v.setModelCode(vehicle.getModelCode());
//		v.setBrandId(vehicle.getBrandId());
		return v;
	}

	private AppGraphQLException vehicleNotFound(Long vehicleId) {
		return new AppGraphQLException("Vehicle with id  " + vehicleId + " not found");
	}

	private AppGraphQLException brandNotFoundException(String brandName) {
		return new AppGraphQLException("Brand " + brandName + " not found");
	}
}
