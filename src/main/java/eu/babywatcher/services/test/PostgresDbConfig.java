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
@EnableJpaRepositories(entityManagerFactoryRef = "posEntityManagerFactory",
    basePackages = {"eu.babywatcher.services.test.postgres.repo"})
public class PostgresDbConfig {

  @Primary
  @Bean(name = "postgres")
  @ConfigurationProperties(prefix = "postgres.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Primary
  @Bean(name = "posEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean posEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("postgres") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("eu.babywatcher.services.test.postgres.domain").persistenceUnit("postgres")
        .build();
  }

  @Primary
  @Bean(name = "posTransactionManager")
  public PlatformTransactionManager posTransactionManager(
      @Qualifier("posEntityManagerFactory") EntityManagerFactory posEntityManagerFactory) {
    return new JpaTransactionManager(posEntityManagerFactory);
  }
} 