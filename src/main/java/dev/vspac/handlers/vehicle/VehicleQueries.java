package dev.vspac.handlers.vehicle;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import dev.vspac.domain.Vehicle;
import dev.vspac.service.VehicleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleQueries implements GraphQLQueryResolver {
	private final VehicleService service;

	@Autowired
	public VehicleQueries(VehicleService service) {
		this.service = service;
	}

	public Optional<Vehicle> vehicle(Long id) {
		return service.byId(id);
	}

	public List<Vehicle> vehicles(int count) {
		return service.findAll(count);
	}
}