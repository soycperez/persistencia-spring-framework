package com.spring.hibernate.config;



import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource(value = "classpath:database.properties")
@ComponentScan(basePackages = {"com.spring.hibernate"})
public class DBConfig {
	
	@Autowired
	private Environment env; 
	
	@Bean
	public HibernateTemplate hibernateTemplate(){
		HibernateTemplate hibernateTemplate = new HibernateTemplate(); 
		hibernateTemplate.setSessionFactory(sessionFactory());
		return hibernateTemplate;
	}
	

	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(dataSource());
		lsfb.setPackagesToScan("com.spring.hibernate.entities");
		lsfb.setHibernateProperties(hibernateProperties());
		try {
		  lsfb.afterPropertiesSet();
		} catch (IOException e) {
		  e.printStackTrace();
		}
		return lsfb.getObject();
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return properties;
	}

}
