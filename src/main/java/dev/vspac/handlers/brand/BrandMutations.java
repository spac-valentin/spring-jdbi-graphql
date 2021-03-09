package dev.vspac.handlers.brand;

import dev.vspac.AppGraphQLException;
import dev.vspac.domain.Brand;
import dev.vspac.domain.ImmutableBrand;
import dev.vspac.dto.brand.CreatingBrandDto;
import dev.vspac.dto.brand.BrandDto;
import dev.vspac.dto.brand.CreatingSubBrandDto;
import dev.vspac.exceptions.graphql.BrandNotFoundException;
import dev.vspac.exceptions.service.BrandAlreadyExistsException;
import dev.vspac.mappers.BrandMapper;
import dev.vspac.mappers.BrandMapperImpl;
import dev.vspac.service.BrandService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class BrandMutations implements GraphQLMutationResolver {
	private final BrandService service;
	private final BrandMapper brandMapper;

	@Autowired
	public BrandMutations(BrandService service, BrandMapper brandMapper) {
		this.service = service;
		this.brandMapper = new BrandMapperImpl();
	}

	public BrandDto addBrand(@Valid CreatingBrandDto dto) {
		Brand brand = brandMapper.fromCreatingBrandDto(dto);
		System.out.println(dto);
		try {
			Brand savedBrand = service.add(brand);
			return brandMapper.toBrandDto(savedBrand);
		} catch (BrandAlreadyExistsException e) {
			throw new AppGraphQLException(e.getMessage());
		}
	}

	public BrandDto updateBrand(Long id, @Valid CreatingBrandDto dto) {
		Brand brand = ImmutableBrand.builder()
											.from(brandMapper.fromCreatingBrandDto(dto))
											.id(id)
				              .build();
		Brand updatedBrand = service.update(brand).orElseThrow(
				() -> new BrandNotFoundException(id));
		return brandMapper.toBrandDto(updatedBrand);
	}

	public BrandDto addSubBrand(@Valid CreatingSubBrandDto dto) {
		String superBrandName = dto.getSubBrandOf();
		Brand superBrand = service.findByName(superBrandName).orElseThrow(
				() -> new BrandNotFoundException(superBrandName));

		String superBrandManagerName = superBrand.getManagerName();

		Brand brand = brandMapper.fromCreatingSubBrandDto(dto, superBrandManagerName);

		try {
			Brand savedBrand = service.add(brand);
			return brandMapper.toBrandDto(savedBrand);
		} catch (BrandAlreadyExistsException e) {
			throw new AppGraphQLException(e.getMessage());
		}
	}
}
