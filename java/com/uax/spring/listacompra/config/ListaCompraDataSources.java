package com.uax.spring.listacompra.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ListaCompraDataSources {

	@Bean("db1")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource getDBCopmras() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("db2")
	@ConfigurationProperties(prefix="spring.segunda.db")
	public DataSource getDBProveedor() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("db1") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	@Bean(name="jdbcTemplateDB2")
	public JdbcTemplate getJdbcTemplateDB2(@Qualifier("db2") DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
