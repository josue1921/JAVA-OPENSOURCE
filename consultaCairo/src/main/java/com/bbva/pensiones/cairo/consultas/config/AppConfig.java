package com.bbva.pensiones.cairo.consultas.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("com.bbva.pensiones.cairo.consultas.dao.imp"), @ComponentScan("com.bbva.pensiones.cairo.consultas.service.imp") })
public class AppConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		Properties props = new Properties();
		
		// MySql Properties
		//props.put(DRIVER, env.getProperty("mysql.driver"));
		//props.put(URL, env.getProperty("mysql.url"));
		//props.put(USER, env.getProperty("mysql.user"));
		//props.put(PASS, env.getProperty("mysql.password"));
		
		// SqlServer Properties
		props.put(DRIVER, env.getProperty("sqlserver.driver"));
		props.put(URL, env.getProperty("sqlserver.url"));
		props.put(USER, env.getProperty("sqlserver.user"));
		props.put(PASS, env.getProperty("sqlserver.password"));
		
		//Hibernate Properties
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		props.put(DIALECT, env.getProperty("hibernate.dialect"));
		
		// CP30 Properties
		props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
		
		factoryBean.setHibernateProperties(props);
		
		factoryBean.setPackagesToScan("com.bbva.pensiones.cairo.consultas.entities");
		
		return factoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	
	
}
