package es.netmind.banana_invoices.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import es.netmind.banana_invoices.persistence.IPropietarioRepo;
import es.netmind.banana_invoices.persistence.IReciboRepo;
import es.netmind.banana_invoices.persistence.JPAIReciboRepo;
import es.netmind.banana_invoices.persistence.JPAPropietarioRepo;

@Configuration
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class ReposConfig {
	
	@Autowired
	private Environment env;
	
	// sustituye al .xml de configuracion
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	// JPA transaction manager
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager =
				new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				invoicesEmf().getObject());
		return transactionManager;
	}
		
	@Bean
	DataSource invoicesDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(env.getProperty("invoices.url"));
		ds.setDriverClassName(env.getProperty("invoices.driverClassName"));
		ds.setUsername("invoices_user");
		ds.setPassword("inv123");
		return ds;
	}
	
	@Bean
	public JpaVendorAdapter vendorAdapter() {
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setShowSql(true);
		va.setGenerateDdl(true);
		return va;
	}
	
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean invoicesEmf() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		em.setPersistenceUnitName(env.getProperty("invoices.persistenceUnitName"));
		
		em.setDataSource(invoicesDataSource());
		em.setPackagesToScan("es.netmind.banana_invoices.*");
		em.setJpaVendorAdapter(vendorAdapter());
		em.setJpaProperties(additionalProperties());
		return em;
	}
	
	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", env.getProperty("invoices.dialect")); 
		return properties;
	}
	
	@Bean
	public IPropietarioRepo iPropietarioRepo() {
		return new JPAPropietarioRepo();
	}
	
	@Bean
	public IReciboRepo recRepository()	 {
		return new JPAIReciboRepo();
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
