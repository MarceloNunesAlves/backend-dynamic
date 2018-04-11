package br.com.flexvision.befd;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactory",
  basePackages = { "br.com.flexvision.befd.flex4" }
)
public class Flex4DbConfig {

	@Autowired
	private Environment env;
	
	@Bean(name = "flex4DataSource")
	@ConfigurationProperties(prefix = "flex4.datasource")
	public DataSource dataSource() {
		//return DataSourceBuilder.create().build();
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("flex4.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("flex4.datasource.url"));
		dataSource.setUsername(env.getProperty("flex4.datasource.username"));
		dataSource.setPassword(env.getProperty("flex4.datasource.password"));
		return dataSource;
	}

	@Bean(name = "flex4EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean flex4EntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("flex4DataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = builder.dataSource(dataSource).packages("br.com.flexvision.befd.flex4").persistenceUnit("flex4").build();
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    em.setJpaVendorAdapter(vendorAdapter);
	    HashMap<String, String> properties = new HashMap<>();
	    properties.put("hibernate.ddl.auto", "none");
	    properties.put("hibernate.show.sql", "true");
	    em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean(name = "flex4TransactionManager")
	public PlatformTransactionManager barTransactionManager(@Qualifier("flex4EntityManagerFactory") EntityManagerFactory flex4EntityManagerFactory) {
		return new JpaTransactionManager(flex4EntityManagerFactory);
	}
}
