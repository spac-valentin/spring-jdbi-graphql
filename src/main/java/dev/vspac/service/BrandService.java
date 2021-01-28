package dev.vspac.service;

import dev.vspac.dao.BrandDao;
import dev.vspac.domain.Brand;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public Brand add(Brand brand) {
		Optional<Brand> existingBrand = this.findByName(brand.getName());
		if(existingBrand.isPresent()) {
			throw new BrandNotFoundException("Brand " + brand.getName() + " already exists");
		}

		long id = dao.insert(brand);
		brand.setId(id);
		return brand;
	}

	public List<Brand> findAll(int count) {
		return dao.findAll(count);
	}

	public Optional<Brand> findByName(String brandName) {
		return dao.findByName(brandName);
	}

	public static class BrandNotFoundException extends RuntimeException {
		public BrandNotFoundException(String msg) {
			super(msg);
		}
	}
}

