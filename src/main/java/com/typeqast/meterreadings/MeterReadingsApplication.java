package com.typeqast.meterreadings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class MeterReadingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeterReadingsApplication.class, args);
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	DataSource deviceStatusDatasource() {
		return DataSourceBuilder.create().build();
	}
}
