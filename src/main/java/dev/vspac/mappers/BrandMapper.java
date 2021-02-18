package dev.vspac.mappers;

import dev.vspac.domain.Brand;
import dev.vspac.domain.ImmutableBrand;
import dev.vspac.dto.brand.BrandDto;
import dev.vspac.dto.brand.CreatingBrandDto;
import dev.vspac.dto.brand.CreatingSubBrandDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BrandMapper {
	BrandDto toBrandDto(Brand brand);

	Brand fromCreatingBrandDto(CreatingBrandDto dto);

	default Brand fromCreatingSubBrandDto(
			CreatingSubBrandDto dto, String managerName) {
		return ImmutableBrand.builder()
							 .name(dto.getName())
							 .country(dto.getCountry())
							 .managerName(managerName)
				       .build();
	}
}
