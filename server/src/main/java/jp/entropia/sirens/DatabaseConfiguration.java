package jp.entropia.sirens;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
	
	@Autowired
    DataSourceProperties properties;
	
	@Bean
	public DataSource dataSource() {

        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName(properties.getDriverClassName());
        ds.setUrl(properties.getUrl());
        ds.setUsername(properties.getUsername());
        ds.setPassword(properties.getPassword());
        ds.setDefaultAutoCommit(false);
        ds.setValidationQuery("SELECT 1");
        ds.setTestOnBorrow(true);
        ds.setTestWhileIdle(true);

        return ds;
    }
	
    @Bean
    public Dialect dialect() {
        return new MysqlDialect();
    }

    @Bean
    public SqlFileRepository sqlFileRepository() {
        return new NoCacheSqlFileRepository();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public Config config() {
        return new Config() {

            @Override
            public Dialect getDialect() {
                return dialect();
            }

            @Override
            public DataSource getDataSource() {
            	return new TransactionAwareDataSourceProxy(dataSource());
            }

            @Override
            public SqlFileRepository getSqlFileRepository() {
                return sqlFileRepository();
            }
            
        };
    }

}
