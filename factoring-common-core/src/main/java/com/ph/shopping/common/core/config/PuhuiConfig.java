package com.ph.shopping.common.core.config;

import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 普惠接口
 * @author xwolf
 * @date 2017-09-01 10:45
 * @since 1.8
 **/
@Configuration
//@PropertySource(value = "classpath:puhui.properties")
public class PuhuiConfig {

    private InitParams initParams = new InitParams("/web_tianti/factoring-common-core/resources/puhui.properties");

    /**
     * 添加积分(天天返、刮红包)
     */
    private String add;
    /**
     * 获取积分
     */
    private String selectScore;
    /**
     * 积分提现
     */
    private String cash;

    public String getAdd() {
        return initParams.getProperties().getProperty("puhui.score.add");
    }

    public String getCash() {
        return initParams.getProperties().getProperty("puhui.score.get");
    }

    public String getSelectScore() {
        return initParams.getProperties().getProperty("puhui.score.cash");
    }
}
