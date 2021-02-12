package dev.vspac.dao;

import dev.vspac.domain.ImmutableVehicle;
import dev.vspac.domain.Vehicle;
import java.util.List;
import java.util.Optional;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface VehicleDao {

	@SqlUpdate("insert")
	@GetGeneratedKeys
	@UseClasspathSqlLocator
	Long insert(@BindBean Vehicle vehicle);

	@SqlQuery("Select * from vehicle where id = :id")
	@RegisterConstructorMapper(ImmutableVehicle.class)
	Optional<Vehicle> findById(@Bind("id") Long id);

	@SqlQuery("select id as id, brand_id, model_code as modelCode from vehicle limit ?")
	@RegisterConstructorMapper(ImmutableVehicle.class)
	List<Vehicle> findAll(int limit);
}
