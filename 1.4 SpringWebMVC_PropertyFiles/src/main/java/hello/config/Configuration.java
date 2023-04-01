package hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import hello.model.Order;
import hello.model.Person;

@org.springframework.context.annotation.Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hello")
public class Configuration implements WebMvcConfigurer {
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resource = new InternalResourceViewResolver();
		resource.setViewClass(JstlView.class);
		resource.setPrefix("/WEB-INF/views/");
		resource.setSuffix(".jsp");
		return resource;
	}

	@Bean(name = "person", initMethod = "init", destroyMethod = "destroy")
	@Scope(value="prototype")
	public Person person() {
		Person pr = new Person("Duc Viet", 19);
		return pr;
	}
	
	@Bean(name = "person2")
	public Person person2() {
		Person pr = new Person("Nguyen Duc Viet", 19);
		return pr;
	}
	
	@Bean
	@Autowired
	@Qualifier("person2")
	public Order order(Person person) {
		return new Order(person);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public MessageSource getMessageSource() {
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("messages");
		return resource;
	}
}
