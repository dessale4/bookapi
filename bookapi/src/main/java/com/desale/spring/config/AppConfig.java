//// for this project this file is not working well(so is not in use)
//package com.desale.spring.config;
//
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScans;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import static org.hibernate.cfg.Environment.*; // will give us the driver class in mysql connection below (Provides access to configuration info passed in Properties objects.)
////import static org.hibernate.cfg.Environment.*;
//@Configuration  //informs spring container that this is a configuration file
//@PropertySource("classpath:db.properties")  //informs spring container where the properties file is located
//@EnableTransactionManagement
//@ComponentScans(value = {
//		@ComponentScan("com.desale.spring.dao"),
//		@ComponentScan("com.desale.spring.service"),
//		@ComponentScan("com.desale.spring.controller")
//})
//
//public class AppConfig {
//	
//	
//	@Autowired
//	private Environment env; // will help us to read from properties file
//	
//	// create for bean LocalSessionFactoryBean
//	@Bean
//	public LocalSessionFactoryBean getSessionFactory() {
//		
//		 LocalSessionFactoryBean  factoryBean = new  LocalSessionFactoryBean();
//		 Properties props =  new Properties();
//		 
//		 //Setting JDBC properties
//		 
//			 System.out.println("check "+env.getProperty("mysql.driver"));
//		 props.put(DRIVER, env.getProperty("mysql.driver"));
//		 props.put(URL, env.getProperty("mysql.url"));
//		 props.put(USER, env.getProperty("mysql.user"));
//		 props.put(PASS, env.getProperty("mysql.password"));
////		 props.put(DIALECT, env.getProperty("mysql.dialect"));
//		 
//		 
//		 
//		 //Setting hibernate properties
//		 
//		 props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
//		 props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
//		 
//		 // Setting C3P0 Properties 
//		 props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
//		 props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
//		 props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
//		 props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
//		 props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
////		 props.put(C3P0_CONFIG_PREFIX+".initialPoolSize", env.getProperty("hibernate.c3p0.C3P0_CONFIG_PREFIX"));
//		 
////		 ===============================
//		 
////		 props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
////		 props.put(Environment.URL, "jdbc:mysql://localhost:3360/bookapi");
////		 props.put(Environment.USER, "root");
////		 props.put(Environment.PASS, "Mymysql1");
////		 props.put(Environment.SHOW_SQL, "true");
////		 props.put(Environment.HBM2DDL_AUTO, "create");
////		 props.put(Environment.C3P0_MIN_SIZE, 5);
////		 props.put(Environment.C3P0_MAX_SIZE, 20);
////		 props.put(Environment.C3P0_ACQUIRE_INCREMENT, 1);
////		 props.put(Environment.C3P0_TIMEOUT, 1800);
////		 props.put(Environment.C3P0_MAX_STATEMENTS, 150);
////		 =================================
//	
//		 //assign props to factoryBean
//		 
//		 factoryBean.setHibernateProperties(props);
//		 
//		 // tell factoryBean from where to create our entity table 
//		 
//		 factoryBean.setPackagesToScan("com.desale.spring.model");
//
//		 System.out.println("From here2");
//		 
//		 return factoryBean;
//		 
//	}
//	
//	@Bean
//	public HibernateTransactionManager getTransactionManager() {
//		System.out.println("From here and here");
//		HibernateTransactionManager transactionManager  = new HibernateTransactionManager();
//		
//		transactionManager.setSessionFactory(getSessionFactory().getObject());//getSessionFactory()
//
//		 System.out.println("From hibernate transaction manager");
//		return transactionManager;
//	}
//}
