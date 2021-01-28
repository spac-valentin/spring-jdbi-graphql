package dev.vspac.handlers.brand;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import dev.vspac.domain.Brand;
import dev.vspac.service.BrandService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandQueries implements GraphQLQueryResolver {
	private final BrandService service;

	@Autowired
	public BrandQueries(BrandService service) {
		this.service = service;
	}

	public List<Brand> brands(int count) {
		return service.findAll(count);
	}

}
