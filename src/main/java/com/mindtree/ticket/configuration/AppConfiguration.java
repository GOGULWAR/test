package com.mindtree.ticket.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Component //says this class is of configuration
@EnableWebMvc 
@ComponentScan(basePackages="com.mindtree")
public class AppConfiguration {
	

}
