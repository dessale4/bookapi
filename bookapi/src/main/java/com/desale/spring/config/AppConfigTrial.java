package com.desale.spring.config;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.desale.spring.model.Book;

@Configuration  //informs spring container that this is a configuration file
@PropertySource("classpath:db.properties")  //informs spring container where the properties file is located
@EnableTransactionManagement
@ComponentScans(value = {
		@ComponentScan("com.desale.spring.dao"),
		@ComponentScan("com.desale.spring.service"),
		@ComponentScan("com.desale.spring.controller" )
})

public class AppConfigTrial {
	
	private static StandardServiceRegistry registry;
//	   private static SessionFactory sessionFactory;
	private static SessionFactory sessionFactory;
//	   LocalSessionFactoryBean  factoryBean = new  LocalSessionFactoryBean();
	   
	   @Bean
	   public static SessionFactory getSessionFactory() {
		   
	      if (sessionFactory == null) {
	         try {
	            StandardServiceRegistryBuilder registryBuilder =
	                  new StandardServiceRegistryBuilder();

	            Map<String, Object> settings = new HashMap<>();
	            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bookapi?useSSL=false");
	            settings.put(Environment.USER, "root");
	            settings.put(Environment.PASS, "Mymysql1");
	            settings.put(Environment.HBM2DDL_AUTO, "create");
	            settings.put(Environment.SHOW_SQL, true);
	          
	            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "org.hibernate.context.internal.ThreadLocalSessionContext");
	            // c3p0 configuration
	            settings.put(Environment.C3P0_MIN_SIZE, 5);         //Minimum size of pool
	            settings.put(Environment.C3P0_MAX_SIZE, 20);        //Maximum size of pool
	            settings.put(Environment.C3P0_ACQUIRE_INCREMENT, 1);//Number of connections acquired at a time when pool is exhausted 
	            settings.put(Environment.C3P0_TIMEOUT, 1800);       //Connection idle time
	            settings.put(Environment.C3P0_MAX_STATEMENTS, 150); //PreparedStatement cache size

	            settings.put(Environment.C3P0_CONFIG_PREFIX+".initialPoolSize", 5);
	            
	            registryBuilder.applySettings(settings);
	            
	            registry = registryBuilder.build();
	            MetadataSources sources = new MetadataSources(registry)
	                  .addAnnotatedClass(Book.class);
	            Metadata metadata = sources.getMetadataBuilder().build();
	            sessionFactory = metadata.getSessionFactoryBuilder().build();
	         } catch (Exception e) {
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	            e.printStackTrace();
	         }
	      }
	      return sessionFactory;
	   }
	   
	   @Bean
	public HibernateTransactionManager getTransactionManager() {
//		System.out.println("From here and here");
		HibernateTransactionManager transactionManager  = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(getSessionFactory());//getSessionFactory()

		 System.out.println("From hibernate transaction manager");
		return transactionManager;
	}

//	   @Bean
//	   public static void shutdown() {
//	      if (registry != null) {
//	    	 System.out.println("from trial configuration");
//	         StandardServiceRegistryBuilder.destroy(registry);
//	      }
//	   }
//	   @Bean
//	    public HttpMessageConverters customConverters() {
//
//	        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//
//	        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
//	        messageConverters.add(gsonHttpMessageConverter);
//
//	        return new HttpMessageConverters(true, messageConverters);
//	    }
}
