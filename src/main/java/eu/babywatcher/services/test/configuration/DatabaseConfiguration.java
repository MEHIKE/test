package eu.babywatcher.services.test.configuration;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
//@Configuration
//@EnableTransactionManagement(proxyTargetClass = true)
public class DatabaseConfiguration{

    //static transient Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class.getName());

/*    @Autowired
    private ApplicationContext applicationContext;

    @Value("${postgres.datasource.url}")
    private String url;


    @Primary
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "postgres.datasource")
    public DataSource postgresDataSource(){
        //log.info("URL======"+url);
        return DefaultDataSourceBuilder.create().build( DefaultDataSourceBuilder.Type.ORACLE );
    }

    @Bean(name = "postgres2DataSource")
    @ConfigurationProperties(prefix = "postgres2.datasource")
    public DataSource postgres2DataSource(){
        return DefaultDataSourceBuilder.create().build( DefaultDataSourceBuilder.Type.ORACLE );
    }

    @Bean(name = "postgresTemplate")
    public JdbcTemplate postgresTemplate(){
        return new JdbcTemplate( postgresDataSource() );
    }


    @Bean(name = "postgres2Template")
    public JdbcTemplate postgres2Template(){
        return new JdbcTemplate( postgres2DataSource() );
    }

    private Resource getResourceByEnvProperty( String environmentProperty ) throws IOException{
        return applicationContext.getResource( "file:" + applicationContext.getEnvironment().getProperty( environmentProperty ) );
    }
*/
}
