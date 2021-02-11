package dev.vspac.handlers.brand;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import dev.vspac.dto.brand.BrandDto;
import dev.vspac.dto.brand.ImmutableBrandDto;
import dev.vspac.service.BrandService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandQueries implements GraphQLQueryResolver {
	private final BrandService service;

	@Autowired
	public BrandQueries(BrandService service) {
		this.service = service;
	}

	public List<BrandDto> brands(int count) {
		return service.findAll(count).stream()
				       .map(b -> ImmutableBrandDto.builder()
						                 .id(b.id())
						                 .name(b.name())
						                 .country(b.country())
						                 .build())
				       .collect(Collectors.toList());
	}
}
