package dev.vspac.handlers.vehicle;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import dev.vspac.domain.Vehicle;
import dev.vspac.dto.vehicle.VehicleDto;
import dev.vspac.exceptions.graphql.VehicleNotFoundException;
import dev.vspac.mappers.VehicleMapper;
import dev.vspac.service.VehicleService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleQueries implements GraphQLQueryResolver {
	private final VehicleService service;
	private final VehicleMapper vehicleMapper;

	@Autowired
	public VehicleQueries(VehicleService service, VehicleMapper vehicleMapper) {
		this.service = service;
		this.vehicleMapper = vehicleMapper;
	}

	public VehicleDto vehicle(Long id) {
		Vehicle vehicle = service.byId(id).orElseThrow(
				() -> new VehicleNotFoundException(id));
		return vehicleMapper.toVehicleDto(vehicle);
	}

	public List<VehicleDto> vehicles(int count) {
		return service.findAll(count)
				       .stream()
				       .map(vehicleMapper::toVehicleDto)
				       .collect(Collectors.toList());
	}
}
