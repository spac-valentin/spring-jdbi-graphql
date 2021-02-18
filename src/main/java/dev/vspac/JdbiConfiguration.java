package dev.vspac;

import dev.vspac.dao.BrandDao;
import dev.vspac.dao.VehicleDao;

import dev.vspac.domain.Brand;
import dev.vspac.domain.Vehicle;
import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.immutables.JdbiImmutables;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class JdbiConfiguration {
    @Bean
    public Jdbi jdbi(DataSource ds) throws ClassNotFoundException {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(ds);        
        Jdbi jdbi = Jdbi.create(proxy);
        jdbi.installPlugin(new SqlObjectPlugin());

        return jdbi;
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                   .setType(EmbeddedDatabaseType.H2)
                   .addScript("db_script.sql")
                   .build();
    }

    @Bean
    public VehicleDao vehicleDao(Jdbi jdbi) {
        return jdbi.onDemand(VehicleDao.class);
    }

    @Bean
    public BrandDao brandDao(Jdbi jdbi) {
        jdbi.getConfig(JdbiImmutables.class).registerImmutable(Brand.class);
        return jdbi.onDemand(BrandDao.class);
    }
}
