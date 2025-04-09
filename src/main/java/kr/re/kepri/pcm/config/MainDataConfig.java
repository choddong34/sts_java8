package kr.re.kepri.pcm.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/database.properties")
@MapperScan(basePackages = "kr.re.kepri.pcm.*.mapper", sqlSessionFactoryRef = "mainSqlSessionFactory")
@EnableTransactionManagement
public class MainDataConfig {

    private final ApplicationContext applicationContext;

    public MainDataConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Value("${spring.main.datasource.mapper-locations}")
    private String mapperLocation;

    @Value("${spring.main.datasource.mybatis-config}")
    private String configPath;

    @Bean(name="mainDatasource")
    @ConfigurationProperties("spring.main.datasource")
    public DataSource mainDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="mainSqlSessionFactory")
    public SqlSessionFactory mainSqlSessionFactory(@Qualifier("mainDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mapperLocation));

        Resource configLocation = new PathMatchingResourcePatternResolver().getResource(configPath);
        sqlSessionFactoryBean.setConfigLocation(configLocation);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public TransactionManager mainTransactionManager() {
        return new DataSourceTransactionManager(mainDatasource());
    }
}
