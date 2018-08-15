package com.ph.shopping.config.database;


import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.context.annotation.Configuration;

/**
 * @author ywj
 * @since 1.8
 **/
//@PropertySource(value ="classpath:redis.properties")
@Configuration
public class ApplicationConfig {


    private InitParams initParams = new InitParams("/web_tianti/factoring-common-config/resources/application.properties");

   // @ApolloConfig
    //Config config = ConfigService.getAppConfig();

    //@ApolloConfig
   // Config config = ConfigService.getConfig("TEST2.database_configuration");

    /**当前激活的环境
     *
     */
    private String active;
    /**
     *     redis配置
     */
    private String redisHost;
    private String redisDatabase;
    private String redisPort;
    private String redisPassword;
    private String redisTimeout;
    private String redisPoolMaxWait;
    private String redisPoolMaxIdle;
    private String redisPoolMinWait;
    /**
     * 日志配置
     */
    private String loggingZookeeper;
    private String loggingAlibaba;
    /**
     * mybatis扫描xml路径
     */
    private String mybatisPackage;
    private String mybatisLocations;
    /**Mapper配置
     *
     */
    private String mappers;
    private String notEmpty;
    private String identity;


    /**
     *  pageHelper分页数据配置
     */
    private String pagehelperHelperDialect;
    private String pagehelperReasonable;
    private String pagehelperSupportMethodsArguments;
    private String pagehelperParams;
    /**
     *     测环境配置
     */
    private String springProfiles;
    /**
     * 数据库配置
     */

    private String datasourceUrl;
    private String datasourceUsername;
    private String datasourcePassword;
    private String driverClassName;
    /** 使用druid数据源
     *
     */
    private String type;
    private String druidFilters;
    private String druidMaxActive;
    private String druidInitialSize;
    private String druidMaxWait;
    private String druidMinIdle;
    private String druidTimeBetweenEvictionRunsMillis;
    private String druidMinEvictableIdleTimeMillis;
    private String druidValidationQuery;
    private String druidTestWhileIdle;
    private String druidTestOnBorrow;
    private String druiTestOnReturn;
    private String druidConnectionProperties;


    public String getActive() {
        return initParams.getProperties().getProperty("spring.profiles.active");
    }

    public String getRedisHost() {
        //return config.getProperty("spring.redis.host",initParams.getProperties().getProperty("spring.redis.host"));
        return initParams.getProperties().getProperty("spring.redis.host");
    }

    public String getRedisDatabase() {
        return initParams.getProperties().getProperty("spring.redis.database");
    }

    public String getRedisPort() {
        //return config.getProperty("spring.redis.port",initParams.getProperties().getProperty("spring.redis.port"));
        return initParams.getProperties().getProperty("spring.redis.port");
    }

    public String getRedisPassword() {
        return initParams.getProperties().getProperty("spring.redis.password");
    }

    public String getRedisTimeout() {
        return initParams.getProperties().getProperty("spring.redis.timeout");
    }

    public String getRedisPoolMaxWait() {
        return initParams.getProperties().getProperty("spring.redis.pool.max-wait");
    }

    public String getRedisPoolMaxIdle() {
        return initParams.getProperties().getProperty("spring.redis.pool.max-idle");
    }

    public String getRedisPoolMinWait() {
        return initParams.getProperties().getProperty("spring.redis.pool.min-idle");
    }

    public String getLoggingZookeeper() {
        return initParams.getProperties().getProperty("logging.level.org.apache.zookeeper");
    }

    public String getLoggingAlibaba() {
        return initParams.getProperties().getProperty("logging.level.com.alibaba");
    }

    public String getMybatisPackage() {
        return initParams.getProperties().getProperty("mybatis.type-aliases-package");
    }

    public String getMybatisLocations() {
        return initParams.getProperties().getProperty("mybatis.mapper-locations");
    }

    public String getMappers() {
        return initParams.getProperties().getProperty("mapper.mappers");
    }

    public String getNotEmpty() {
        return initParams.getProperties().getProperty("mapper.not-empty");
    }

    public String getIdentity() {
        return initParams.getProperties().getProperty("mapper.identity");
    }

    public String getPagehelperHelperDialect() {
        return initParams.getProperties().getProperty("pagehelper.helperDialect");
    }

    public String getPagehelperReasonable() {
        return initParams.getProperties().getProperty("pagehelper.reasonable");
    }

    public String getPagehelperSupportMethodsArguments() {
        return initParams.getProperties().getProperty("pagehelper.supportMethodsArguments");
    }

    public String getPagehelperParams() {
        return initParams.getProperties().getProperty("pagehelper.params");
    }

    public String getSpringProfiles() {
        return initParams.getProperties().getProperty("spring.profiles");
    }

    public String getDatasourceUrl() {
        //return config.getProperty("spring.datasource.url",initParams.getProperties().getProperty("spring.datasource.url"));
        return initParams.getProperties().getProperty("spring.datasource.url");
    }

    public String getDatasourceUsername() {
        //return config.getProperty("spring.datasource.username",initParams.getProperties().getProperty("spring.datasource.username"));
        return initParams.getProperties().getProperty("spring.datasource.username");
    }

    public String getDatasourcePassword() {
        //return config.getProperty("spring.datasource.password",initParams.getProperties().getProperty("spring.datasource.password"));
        return initParams.getProperties().getProperty("spring.datasource.password");
    }

    public String getDriverClassName() {
        return initParams.getProperties().getProperty("spring.datasource.driver-class-name");
    }

    public String getType() {
        return initParams.getProperties().getProperty("spring.datasource.type");
    }

    public String getDruidFilters() {
        return initParams.getProperties().getProperty("spring.datasource.druid.filters");
    }

    public String getDruidMaxActive() {
        return initParams.getProperties().getProperty("spring.datasource.druid.maxActive");
    }

    public String getDruidInitialSize() {
        return initParams.getProperties().getProperty("spring.datasource.druid.initialSize");
    }

    public String getDruidMaxWait() {
        return initParams.getProperties().getProperty("spring.datasource.druid.maxWait");
    }

    public String getDruidMinIdle() {
        return initParams.getProperties().getProperty("spring.datasource.druid.minIdle");
    }

    public String getDruidTimeBetweenEvictionRunsMillis() {
        return initParams.getProperties().getProperty("spring.datasource.druid.timeBetweenEvictionRunsMillis");
    }

    public String getDruidMinEvictableIdleTimeMillis() {
        return initParams.getProperties().getProperty("spring.datasource.druid.minEvictableIdleTimeMillis");
    }

    public String getDruidValidationQuery() {
        return initParams.getProperties().getProperty("spring.datasource.druid.validationQuery");
    }

    public String getDruidTestWhileIdle() {
        return initParams.getProperties().getProperty("spring.datasource.druid.testWhileIdle");
    }

    public String getDruidTestOnBorrow() {
        return initParams.getProperties().getProperty("spring.datasource.druid.testOnBorrow");
    }

    public String getDruiTestOnReturn() {
        return initParams.getProperties().getProperty("spring.datasource.druid.testOnReturn");
    }

    public String getDruidConnectionProperties() {
        return initParams.getProperties().getProperty("spring.datasource.druid.connectionProperties");
    }


}
