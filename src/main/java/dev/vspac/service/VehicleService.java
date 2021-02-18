package dev.vspac.service;

import dev.vspac.dao.VehicleDao;
import dev.vspac.domain.Vehicle;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class VehicleService {
	private static final Logger log = LoggerFactory.getLogger(VehicleService.class);
	private final VehicleDao dao;

	public VehicleService(VehicleDao dao) {
		this.dao = dao;
	}

	public Optional<Vehicle> byId(Long id) {
		return dao.findById(id);
	}

	@Transactional
	public Vehicle add(final Vehicle vehicle) {
		log.info("Transaction is active: " + TransactionSynchronizationManager.isActualTransactionActive());
		log.info("Current transaction name " + TransactionSynchronizationManager.getCurrentTransactionName());
		long id = dao.insert(vehicle);
		return vehicle.toBuilder().id(id).build();
	}

	public Optional<Vehicle> update(Vehicle vehicle) {
		boolean isUpdated = dao.update(vehicle);
		if(isUpdated) {
			return Optional.of(vehicle);
		}
		return Optional.empty();
	}

	public List<Vehicle> findAll(int count) {
		return dao.findAll(count);
	}
}
