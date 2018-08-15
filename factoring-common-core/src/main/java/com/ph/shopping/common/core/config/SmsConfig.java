package com.ph.shopping.common.core.config;

import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.context.annotation.Configuration;

/**
 * @author xwolf
 * @since 1.8
 **/
@Configuration
public class SmsConfig{

    private InitParams initParams = new InitParams("/web_tianti/factoring-common-core/resources/sms.properties");

    /**
     * 天易发送验证码
     */
    private String sendMsg;

    /**
     * 天易验证码校验
     */
    private String checkMsg;

    /**
     * 代理商/业务员注册
     */
    private String agentRegister;

    /**
     * 快火用户注册/密码找回提醒
     */
    private String password;

    /**
     * 快火代理提醒
     */
    private String agentAlert;


    /**
     * 现金/积分支付
     */
    private String cash;

    /**
     * 快火App预定订单通知
     */
    private String prepay;

    /**
     * 快火App订单支付通知
     */
    private String pay;

    /**
     * 商户/会员推广奖金通知
     */
    private String spread;

    /**
     * 用户支付通知掌柜
     */
    private String memberPay;
    /**
     * 提交订单通知掌柜
     */
    private String submitOrder;

    /**
     * 公共发送验证码
     */
    private String common;

    /**
     * 取消订单
     */
    private String cancelOrder;
    /**
     * 验证验证码
     */
    private String check;

    public String getSendMsg() {
        return initParams.getProperties().getProperty("sms.register.sendMsg");
    }

    public String getCheckMsg() {
        return initParams.getProperties().getProperty("sms.register.checkMsg");
    }

    public String getAgentRegister() {
        return initParams.getProperties().getProperty("sms.register.agent");
    }

    public String getPassword() {
        return initParams.getProperties().getProperty("sms.register.password");
    }

    public String getAgentAlert() {
        return initParams.getProperties().getProperty("sms.register.alert");
    }

    public String getCash() {
        return initParams.getProperties().getProperty("sms.order.cash");
    }

    public String getPrepay() {
        return initParams.getProperties().getProperty("sms.order.prepay");
    }

    public String getPay() {
        return initParams.getProperties().getProperty("sms.order.pay");
    }

    public String getSpread() {
        return initParams.getProperties().getProperty("sms.share.spread");
    }

    public String getMemberPay() {
        return initParams.getProperties().getProperty("sms.order.member.pay");
    }

    public String getSubmitOrder() {
        return initParams.getProperties().getProperty("sms.order.member.submit");
    }

    public String getCommon() {
        return initParams.getProperties().getProperty("sms.common.send");
    }

    public String getCancelOrder() {
        return initParams.getProperties().getProperty("sms.order.cancel");
    }

    public String getCheck() {
        return initParams.getProperties().getProperty("sms.check");
    }
}
