package dev.vspac.service;

import dev.vspac.dao.BrandDao;
import dev.vspac.domain.Brand;
import dev.vspac.domain.ImmutableBrand;
import dev.vspac.exceptions.service.BrandAlreadyExistsException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
	private final BrandDao dao;

	@Autowired
	public BrandService(BrandDao dao) {
		this.dao = dao;
	}

	public Optional<Brand> byId(Long id) {
		return dao.findById(id);
	}

	public Brand add(Brand brand) {
		String brandName = brand.getName();
		Optional<Brand> existingBrand = this.findByName(brandName);
		if(existingBrand.isPresent()) {
			throw new BrandAlreadyExistsException(brandName);
		}
		long id = dao.insert(brand);
		return ImmutableBrand.builder()
				        .from(brand)
				        .id(id)
								.build();
	}

	public Optional<Brand> update(Brand brand) {
		boolean isUpdated = dao.update(brand);
		if(isUpdated) {
			return Optional.of(brand);
		}
		return Optional.empty();
	}

	public List<Brand> findAll(int count) {
		return dao.findAll(count);
	}

	public Optional<Brand> findByName(String brandName) {
		return dao.findByName(brandName);
	}
}

