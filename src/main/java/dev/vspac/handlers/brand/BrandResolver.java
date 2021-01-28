package dev.vspac.handlers.brand;

import com.coxautodev.graphql.tools.GraphQLResolver;
import dev.vspac.domain.Brand;
import dev.vspac.domain.Vehicle;
import dev.vspac.service.BrandService;
import dev.vspac.service.VehicleService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandResolver implements GraphQLResolver<Brand> {

	public String currency(Brand brand) {
		if(isUSA(brand)) {
			return "USD";
		}

		return "EUR";
	}

	private boolean isUSA(Brand brand) {
		return "usa".equalsIgnoreCase(brand.getCountry());
	}
}