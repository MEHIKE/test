package eu.babywatcher.services.test.configuration;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Slf4j
public class DefaultDataSourceBuilder {//extends DataSourceBuilder {

    public enum Type {
        ORACLE,
        POSTGRESQL,
        MSSQL
    }

    public DefaultDataSourceBuilder( ClassLoader classLoader ) {
        //super( classLoader );
    }


    public static DefaultDataSourceBuilder create() {
        return new DefaultDataSourceBuilder( null );
    }

/*    public DataSource build( Type dataSourceType ) {
        DataSource ds = super.build();
        if( ds instanceof org.apache.tomcat.jdbc.pool.DataSource ) {
            //log.debug( "Setting default tomcat JDBC properties" );
            org.apache.tomcat.jdbc.pool.DataSource dataSource = (org.apache.tomcat.jdbc.pool.DataSource)ds;

            if( "".equals( dataSource.getValidationQuery() ) || dataSource.getValidationQuery() == null ) {
                dataSource.setValidationQuery( "select 1" );

                if( dataSourceType == Type.ORACLE ) {
                    dataSource.setValidationQuery( "select 1 FROM DUAL" );
                }
                if( dataSourceType == Type.MSSQL ) {
                    dataSource.setValidationQuery( "SELECT getdate()" );
                }
            }

            dataSource.setMinIdle( 0 );
            dataSource.setMaxAge( 3600000l );
            dataSource.setLogAbandoned( true );
            dataSource.setSuspectTimeout( 60 );
            dataSource.setLogValidationErrors( true );
            dataSource.setFairQueue( true );
            dataSource.setTimeBetweenEvictionRunsMillis( 10000 );
            dataSource.setMinEvictableIdleTimeMillis( 600000 );
            dataSource.setRemoveAbandoned( true );
            dataSource.setRemoveAbandonedTimeout( 600000 );
            dataSource.setAbandonWhenPercentageFull( 75 );
            dataSource.setJmxEnabled( true );
            dataSource.setValidationInterval( 5000 );
            dataSource.setTestWhileIdle( true );
            dataSource.setTestOnBorrow( true );
            dataSource.setTestOnReturn( true );
            dataSource.setDefaultTransactionIsolation( 2 );

        }
        return ds;
    }*/
}