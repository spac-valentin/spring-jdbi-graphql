package dev.vspac.handlers.brand;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import dev.vspac.dto.brand.BrandDto;
import dev.vspac.mappers.BrandMapper;
import dev.vspac.service.BrandService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandQueries implements GraphQLQueryResolver {
	private final BrandService service;
	private final BrandMapper brandMapper;

	@Autowired
	public BrandQueries(BrandService service, BrandMapper brandMapper) {
		this.service = service;
		this.brandMapper = brandMapper;
	}

	public List<BrandDto> brands(int count) {
		return service.findAll(count).stream()
				       .map(brandMapper::toBrandDto)
				       .collect(Collectors.toList());
	}
}
