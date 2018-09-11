package eu.babywatcher.services.test;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "pos2EntityManagerFactory",
    basePackages = {"eu.babywatcher.services.test.postgres2.repo"})
public class Postgres2DbConfig {

  @Bean(name = "postgres2")
  @ConfigurationProperties(prefix = "postgres2.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "pos2EntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean pos2EntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("postgres2") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("eu.babywatcher.services.test.postgres2.domain").persistenceUnit("postgres2")
        .build();
  }

  @Bean(name = "pos2TransactionManager")
  public PlatformTransactionManager pos2TransactionManager(
      @Qualifier("pos2EntityManagerFactory") EntityManagerFactory pos2EntityManagerFactory) {
    return new JpaTransactionManager(pos2EntityManagerFactory);
  }
} 