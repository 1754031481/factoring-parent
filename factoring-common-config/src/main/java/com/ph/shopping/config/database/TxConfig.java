/*
package com.ph.shopping.config.database;


import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @author ywj
 * @since 1.8
 **//*

//@PropertySource(value ="classpath:redis.properties")
@Configuration
public class TxConfig {

    private InitParams initParams = new InitParams("/web_tianti/factoring-common-config/resources/tx.properties");

    private String url;
    private String dbType;

    public String getUrl() {
        return initParams.getProperties().getProperty("url");
    }

    public String getDbType() {
        return initParams.getProperties().getProperty("compensate.db.dbType");
    }
}
*/
