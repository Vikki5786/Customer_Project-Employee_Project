package com.example.demo.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
/*@EnableJpaRepositories(
		basePackages = {"com.example.demo.api.model"},
		entityManagerFactoryRef = "customerEntityManagerFactory",
		transactionManagerRef = "customerTransactionManager")*/
//@EnableTransactionManagement
public class CustomerJpaConfiguration {
	@Bean
	public DataSource customerDataSource() {
		JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		return dsLookup.getDataSource("jdbc/your_datasource");
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(customerDataSource());
		emf.setPackagesToScan("com.example.demo.api.model");
		return emf;
	}
	@Bean
	public JpaTransactionManager customerTransactionManager() {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(customerEntityManagerFactory().getObject());
		return tm;
	}
}
