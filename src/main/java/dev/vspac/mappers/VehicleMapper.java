package dev.vspac.mappers;

import dev.vspac.domain.Vehicle;
import dev.vspac.dto.vehicle.CreatingNoBrandIdVehicleDto;
import dev.vspac.dto.vehicle.CreatingVehicleDto;
import dev.vspac.dto.vehicle.VehicleDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VehicleMapper {

	VehicleDto toVehicleDto(Vehicle vehicle);

	Vehicle fromCreatingNoBrandIdVehicleDto(CreatingNoBrandIdVehicleDto dto);

	Vehicle fromCreatingVehicleDto(CreatingVehicleDto creatingVehicleDto);
}
