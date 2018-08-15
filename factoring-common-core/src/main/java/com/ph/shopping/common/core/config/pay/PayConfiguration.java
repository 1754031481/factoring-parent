package com.ph.shopping.common.core.config.pay;

import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @项目：factoring-api-pay
 * @描述：初始化支付配置环境
 * @作者： 张霞
 * @创建时间： 14:37 2017/3/25
 * @Copyright @2017 by zhangxia
 */
@Configuration
public class PayConfiguration {

    private static InitParams initParams = new InitParams("/web_tianti/factoring-common-core/resources/pay.properties");

    private String ecoPay;

    private String aliPay;

    private String cashNOTIFYURL;

    private String jsbUnionUrl;

    /**
     * 北京通用支付 by wang
     */
    private String bjcompay;

    /**
     * pay工程提现
     */
    private String cash;

    public String getEcoPay() {
        return  initParams.getProperties().getProperty("eco_pay");
    }

    public void setEcoPay(String ecoPay) {
        this.ecoPay = ecoPay;
    }

    public String getAliPay() {
        return initParams.getProperties().getProperty("ali_pay");
    }

    public void setAliPay(String aliPay) {
        this.aliPay = aliPay;
    }

    public String getCashNOTIFYURL() {
        return initParams.getProperties().getProperty("cash_notify_url");
    }

    public void setCashNOTIFYURL(String cashNOTIFYURL) {
        this.cashNOTIFYURL = cashNOTIFYURL;
    }

    public String getJsbUnionUrl() {
        return initParams.getProperties().getProperty("jsb_union_url");
    }

    public void setJsbUnionUrl(String jsbUnionUrl) {
        this.jsbUnionUrl = jsbUnionUrl;
    }

    public String getBjcompay() {
        return initParams.getProperties().getProperty("bj_com_pay");
    }

    public void setBjcompay(String bjcompay) {
        this.bjcompay = bjcompay;
    }

    public String getCash() {
        return initParams.getProperties().getProperty("pay.score.cash");
    }
}
