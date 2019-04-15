package com.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.filter.MyFilter;
import com.model.User;

@Configuration
public class MyConfiguration {
   
	@Bean()
	public FilterRegistrationBean myTestRegestration() {
		
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new MyFilter());
		filter.addUrlPatterns("/*");
		filter.setName("myFilter");
		//数字越小,优先级越高
        filter.setOrder(6);
        return filter;
	}
	
	@Value("${test.userName}")
	String userName;
	
	@Value("${test.password}")
	String password;
	
	@Value("${test.age}")
	int age;
	
	@Bean
	public User user() {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
	    user.setAge(age);
	    return user;
	} 
}
