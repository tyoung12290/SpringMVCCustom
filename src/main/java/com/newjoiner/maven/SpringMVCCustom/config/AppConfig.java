package com.newjoiner.maven.SpringMVCCustom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.newjoiner.maven.SpringMVCCustom.convertor.PlayerToLineupConvertor;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.newjoiner.maven.SpringMVCCustom")
public class AppConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer{
     
	@Autowired
	PlayerToLineupConvertor playerToLineupConvertor;
	
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // <mvc:resources mapping="/styles/**" location="/css/" />
        registry
            .addResourceHandler("/resources/**") 
            .addResourceLocations("/resources/"); // Spring 4.1
    }
    
    /**
     * Configure Converter to be used.
     * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(playerToLineupConvertor);
    }
    
    
}