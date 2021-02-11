package dev.vspac.handlers.vehicle;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import dev.vspac.AppGraphQLException;
import dev.vspac.domain.Vehicle;
import dev.vspac.dto.vehicle.ImmutableVehicleDto;
import dev.vspac.dto.vehicle.VehicleDto;
import dev.vspac.service.VehicleService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleQueries implements GraphQLQueryResolver {
	private final VehicleService service;

	@Autowired
	public VehicleQueries(VehicleService service) {
		this.service = service;
	}

	public VehicleDto vehicle(Long id) {
		Vehicle vehicle = service.byId(id).orElseThrow(
				() -> new AppGraphQLException("Could not find Vehicle with id " + id));
		return ImmutableVehicleDto.builder()
				       .id(vehicle.id())
				       .modelCode(vehicle.modelCode())
				       .brandId(vehicle.brandId())
				       .build();
	}

	public List<VehicleDto> vehicles(int count) {
		return service.findAll(count).stream()
				       .map(v -> ImmutableVehicleDto.builder()
						                 .id(v.id())
						                 .modelCode(v.modelCode())
						                 .brandId(v.brandId())
						                 .build())
				       .collect(Collectors.toList());
	}
}