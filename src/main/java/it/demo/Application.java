package it.demo;

import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.model.query.builder.sql.SqlQueryConfiguration;
import io.micronaut.runtime.Micronaut;

@SqlQueryConfiguration.DialectConfiguration(dialect = Dialect.MYSQL)
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}