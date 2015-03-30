package jp.entropia.sirens;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
	
	@Autowired
	private DataSource dataSource;
	
    @Bean
    public Dialect dialect() {
        return new MysqlDialect();
    }

    @Bean
    public SqlFileRepository sqlFileRepository() {
        return new NoCacheSqlFileRepository();
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
                return new TransactionAwareDataSourceProxy(dataSource);
            }

            @Override
            public SqlFileRepository getSqlFileRepository() {
                return sqlFileRepository();
            }
        };
    }

}
