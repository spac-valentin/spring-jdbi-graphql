package dev.vspac.handlers.brand;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import dev.vspac.AppGraphQLException;
import dev.vspac.domain.Brand;
import dev.vspac.domain.ImmutableBrand;
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

	public Brand addBrand(String name, String country) {
		Brand brand = ImmutableBrand.builder()
				              .name(name)
				              .country(country)
				              .build();
		try {
			return service.add(brand);
		} catch (BrandNotFoundException e) {
			throw new AppGraphQLException(e.getMessage());
		}

	}
}
