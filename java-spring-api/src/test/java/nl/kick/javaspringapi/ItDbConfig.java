package nl.kick.javaspringapi;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import jakarta.annotation.PreDestroy;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
class ItDbConfig {

    /**
     * Embedded database.
     *
     * @return embedded database
     */
    @Bean
    public EmbeddedDatabase createDatabase() throws IOException {
        return new EmbeddedDatabase();
    }

    /**
     * Provide our embedded DataSource.
     *
     * @return DataSource datasource connected to embedded postgresql database
     */
    @Bean
    @Primary
    public DataSource dataSource(@Autowired final EmbeddedDatabase embeddedDatabase) {
        return embeddedDatabase.getDataSource();
    }

    /**
     * Make sure to run Liquibase migrations after having created the DataSource.
     *
     * @param dataSource the JDBC {@link DataSource}.
     * @return a {@link SpringLiquibase} object.
     */
    @Bean("liquibase")
    public SpringLiquibase liquibase(final DataSource dataSource) {
        final SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setContexts("junit");
        springLiquibase.setChangeLog("classpath:/changelogs/changelog.xml");
        return springLiquibase;
    }


    /**
     * Embedded PostgreSQL database.
     */
    public static class EmbeddedDatabase {
        private final EmbeddedPostgres embeddedPostgres;

        EmbeddedDatabase() throws IOException {
            embeddedPostgres = EmbeddedPostgres
                    .builder()
                    .start();
        }

        DataSource getDataSource() {
            return embeddedPostgres.getTemplateDatabase();
        }

        @PreDestroy
        void shutdown() throws IOException {
            embeddedPostgres.close();
        }
    }
}