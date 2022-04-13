package ar.com.grupoesfera.repartir.mtest;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@Profile("manualTest")
public class BaseDeDatosFixture {

    private static final String MIGRATION_PATH = "filesystem:src/main/db/migrations";
    private static final String DATA_PATH = "filesystem:src/manualTest/db/migrations";

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void inicializar() {
        Flyway flyway = Flyway
                .configure()
                .dataSource(dataSource)
                .locations(MIGRATION_PATH, DATA_PATH)
                .createSchemas(true)
                .load();

        flyway.clean();
        flyway.migrate();
    }
}
