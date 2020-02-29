package com.desale.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	

	@Override
	protected Class<?>[] getRootConfigClasses() {

		System.out.println("From here 3");
//		return null;
		return new Class[] {WebConfig.class};
//		return new Class[] {AppConfig.class};
//		return new Class[] {AppConfigTrial.class};// this was done when the above line was error prone
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("From here 2");
//		return null;
//		return new Class[] {AppConfig.class};
		return new Class[] {AppConfigTrial.class};
//		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("From here 1");
		return new String[] {"/"};
		
	}

}
