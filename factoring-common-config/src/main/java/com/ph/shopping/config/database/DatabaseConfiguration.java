package com.ph.shopping.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;


/**
 * @项目：factoring-common-core
 *
 * @描述：数据库配置
 *
 * @作者： chang
 *
 * @创建时间：2017年3月8日
 *
 * @Copyright @2017 by Mr.chang
 */
@Configuration
public class DatabaseConfiguration implements EnvironmentAware{


	/**
	 * 日志对象
	 */
	private static Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
	private RelaxedPropertyResolver prop;
	private Environment environment;

	private static ApplicationConfig config = new ApplicationConfig();

	@Bean
	public ServletRegistrationBean druidServlet() {
		return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
	}

	@Override
    public void setEnvironment(Environment environment) {
		this.environment = environment;
		this.prop = new RelaxedPropertyResolver(environment,"spring.datasource.");
	}

	/**
	 * @配置数据库连接池配置
	 * @return
	 */
	@Bean(initMethod="init",destroyMethod="close",name="dataSource")
	@Primary
	public DataSource dataSource(){
		log.info("数据库连接池加载中··············");
		if (StringUtils.isEmpty(config.getDatasourceUrl())) {
			log.error("数据库连接池配置错误,请检查spring配置文件,当前spring配置文件为："+Arrays.toString(environment.getActiveProfiles()));
			throw new ApplicationContextException("数据库连接池配置错误!");
		}else{
			log.info("##################################success1");
			DruidDataSource druid=new DruidDataSource();
			//设置连接池连接基本信息
			druid.setUrl(config.getDatasourceUrl());
			druid.setUsername(config.getDatasourceUsername());
			druid.setPassword(config.getDatasourcePassword());
			druid.setDriverClassName(config.getDriverClassName());
			//连接池初始化参数设置
			druid.setInitialSize(Integer.valueOf(config.getDruidInitialSize()));
			druid.setMinIdle(Integer.valueOf(config.getDruidInitialSize()));
			druid.setMaxActive(Integer.valueOf(config.getDruidMaxActive()));
			druid.setMaxWait(Integer.valueOf(config.getDruidMaxWait()));
			druid.setTimeBetweenConnectErrorMillis(Long.valueOf(config.getDruidTimeBetweenEvictionRunsMillis()));
			druid.setMinEvictableIdleTimeMillis(Long.valueOf(config.getDruidMinEvictableIdleTimeMillis()));
			druid.setValidationQuery(config.getDruidValidationQuery());
			druid.setTestWhileIdle(Boolean.parseBoolean(config.getDruidTestWhileIdle()));
			druid.setTestOnBorrow(Boolean.parseBoolean(config.getDruidTestOnBorrow()));
			druid.setTestOnReturn(Boolean.parseBoolean(config.getDruiTestOnReturn()));
			druid.setConnectionProperties(config.getDruidConnectionProperties());
			log.info("数据库加载资源属性"+ JSONArray.toJSONString(config));
			try {
				druid.setFilters("stat,wall,slf4j,config");
			} catch (SQLException e) {
				log.error("druid数据库连接池初始化异常");
			}
			return druid;
		}
	}

	/*@Bean(initMethod="init",destroyMethod="close",name="compenstateDataSource")
	public DataSource compenstateDataSource(){
		log.info("补偿数据库连接池加载中··············");
		if (StringUtils.isEmpty(config.getDatasourceUrl())) {
			log.error("数据库连接池配置错误,请检查spring配置文件,当前spring配置文件为："+Arrays.toString(environment.getActiveProfiles()));
			throw new ApplicationContextException("数据库连接池配置错误!");
		}else{
			log.info("##################################success2");
			DruidDataSource druid=new DruidDataSource();
			//设置连接池连接基本信息
			druid.setUrl(config.getDatasourceUrl());
			druid.setUsername(config.getDatasourceUsername());
			druid.setPassword(config.getDatasourcePassword());
			druid.setDriverClassName(config.getDriverClassName());
			//连接池初始化参数设置
			druid.setInitialSize(Integer.valueOf(config.getDruidInitialSize()));
			druid.setMinIdle(Integer.valueOf(config.getDruidMinIdle()));
			druid.setMaxActive(Integer.valueOf(config.getDruidMaxActive()));
			druid.setMaxWait(Integer.valueOf(config.getDruidMaxWait()));
			druid.setTimeBetweenConnectErrorMillis(Long.valueOf(config.getDruidTimeBetweenEvictionRunsMillis()));
			druid.setMinEvictableIdleTimeMillis(Long.valueOf(config.getDruidMinEvictableIdleTimeMillis()));
			druid.setValidationQuery(config.getDruidValidationQuery());
			druid.setTestWhileIdle(Boolean.parseBoolean(config.getDruidTestWhileIdle()));
			druid.setTestOnBorrow(Boolean.parseBoolean(config.getDruidTestOnBorrow()));
			druid.setTestOnReturn(Boolean.parseBoolean(config.getDruiTestOnReturn()));
			druid.setConnectionProperties(config.getDruidConnectionProperties());
			log.info("数据库加载资源属性"+ JSONArray.toJSONString(config));
			try {
				druid.setFilters("stat,wall,slf4j,config");
			} catch (SQLException e) {
				log.error("druid数据库连接池初始化异常");
			}
			return druid;
		}
	}*/


	/*@Bean
	public LCNDataSourceProxy getDataSourceProxy(){
		LCNDataSourceProxy proxy = new LCNDataSourceProxy();
		proxy.setDataSource(dataSource());
		proxy.setMaxCount(20);
		return proxy;
	}*/

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setTypeAliasesPackage("com.ph.shopping.facade.*.entity");
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		Resource[] resources=resolver.getResources("classpath:com/ph/shopping/facade/mapper/*.xml");
//		sqlSessionFactoryBean.setMapperLocations(resources);
		Resource resources2=resolver.getResource("classpath:mybatis-config.xml");
		sqlSessionFactoryBean.setConfigLocation(resources2);
		return sqlSessionFactoryBean.getObject();
	}



	@Bean
	public DataSourceTransactionManager transactionManager(){
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}






}
