package dev.vspac.dao;

import dev.vspac.domain.Vehicle;
import java.util.List;
import java.util.Optional;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@UseClasspathSqlLocator
public interface VehicleDao {

	@SqlUpdate("insert")
	@GetGeneratedKeys
	Long insert(@BindBean Vehicle vehicle);


	@SqlUpdate("update")
	boolean update(@BindBean Vehicle vehicle);

	@SqlQuery("findById")
	@RegisterBeanMapper(Vehicle.class)
	Optional<Vehicle> findById(@Bind("id") Long id);

	@SqlQuery("findAll")
	@RegisterBeanMapper(Vehicle.class)
	List<Vehicle> findAll(int limit);
}
