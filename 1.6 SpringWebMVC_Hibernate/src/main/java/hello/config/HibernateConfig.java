package hello.config;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import hello.model.User;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Autowired
	ApplicationContext context;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		sessionFactoryBean.setAnnotatedClasses(User.class);
		return sessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactoryBean().getObject());
		return transactionManager;
	}
}
