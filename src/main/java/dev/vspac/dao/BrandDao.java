package dev.vspac.dao;

import dev.vspac.domain.Brand;
import java.util.List;
import java.util.Optional;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface BrandDao {

	class BrandDaoCatalog {
		public static final String ADD = "insert into brand(name,country) values (:name,:country)";
		public static final String GET_BY_ID = "select * from brand where id = :id";
		public static final String FIND_ALL = "select * from brand limit ?";
		public static final String FIND_BY_NAME = "select * from brand where name = ?";
	}

	@GetGeneratedKeys
	@SqlUpdate(BrandDaoCatalog.ADD)
	Long insert(@BindBean Brand vehicle);

	@SqlQuery(BrandDaoCatalog.GET_BY_ID)
	@RegisterConstructorMapper(Brand.class)
	Optional<Brand> findById(@Bind("id") Long id);

	@SqlQuery(BrandDaoCatalog.FIND_ALL)
	@RegisterConstructorMapper(Brand.class)
	List<Brand> findAll(int limit);

	@SqlQuery(BrandDaoCatalog.FIND_BY_NAME)
	@RegisterConstructorMapper(Brand.class)
  Optional<Brand> findByName(String brandName);
}
