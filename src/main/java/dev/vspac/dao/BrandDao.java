package dev.vspac.dao;

import dev.vspac.domain.Brand;
import java.util.List;
import java.util.Optional;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindPojo;
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
	Long insert(@BindPojo Brand vehicle);

	@SqlQuery(BrandDaoCatalog.GET_BY_ID)
	Optional<Brand> findById(@Bind("id") Long id);

	@SqlQuery(BrandDaoCatalog.FIND_ALL)
	List<Brand> findAll(int limit);

	@SqlQuery(BrandDaoCatalog.FIND_BY_NAME)
  Optional<Brand> findByName(String brandName);
}
