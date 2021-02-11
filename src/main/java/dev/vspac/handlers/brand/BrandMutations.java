package dev.vspac.handlers.brand;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import dev.vspac.AppGraphQLException;
import dev.vspac.domain.Brand;
import dev.vspac.domain.ImmutableBrand;
import dev.vspac.dto.brand.AddBrandDto;
import dev.vspac.dto.brand.BrandDto;
import dev.vspac.dto.brand.ImmutableBrandDto;
import dev.vspac.service.BrandService;
import dev.vspac.service.BrandService.BrandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandMutations implements GraphQLMutationResolver {
	private final BrandService service;

	@Autowired
	public BrandMutations(BrandService service) {
		this.service = service;
	}

	public BrandDto addBrand(AddBrandDto addBrandDto) {
		Brand brand = ImmutableBrand.builder()
				              .name(addBrandDto.name())
				              .country(addBrandDto.country())
				              .build();
		try {
			Brand savedBrand = service.add(brand);
			return ImmutableBrandDto.builder()
					       .id(savedBrand.id())
					       .name(savedBrand.name())
					       .country(savedBrand.country())
					       .build();
		} catch (BrandNotFoundException e) {
			throw new AppGraphQLException(e.getMessage());
		}

	}
}
