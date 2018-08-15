package com.ph.shopping.common.core.config;

import com.ph.shopping.common.core.properties.InitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 推送
 * @author xwolf
 * @since 1.8
 **/
//@PropertySource(value ="classpath:push.properties")
@Configuration
public class PushConfig {

    /**
     * 日志对象
     */
    private static Logger log = LoggerFactory.getLogger(PushConfig.class);

    private InitParams initParams = new InitParams("/web_tianti/factoring-common-core/resources/push.properties");

    /**
     * 推送url
     */
    private String url;

    public String getUrl() {
        return initParams.getProperties().getProperty("jpush.url");
    }
}
