package dev.vspac.handlers.brand;

import dev.vspac.dto.brand.BrandDto;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BrandResolver implements GraphQLResolver<BrandDto> {

	public String currency(BrandDto brandDto) {
		if(isUSA(brandDto)) {
			return "USD";
		}

		return "EUR";
	}

	private boolean isUSA(BrandDto brandDto) {
		return "usa".equalsIgnoreCase(brandDto.getCountry());
	}
}