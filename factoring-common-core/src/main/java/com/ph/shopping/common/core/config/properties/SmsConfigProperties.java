package com.ph.shopping.common.core.config.properties;

import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.stereotype.Component;

/**
 * @package : com.ph.shopping.common.core.config.properties
 * @progect : factoring-parent
 * @Description :
 * @Created by :ZhaoJunBiao
 * @Creation Date ：2018年01月02日9:47
 */
@Component
public class SmsConfigProperties {

    private InitParams initParams = new InitParams("/web_tianti/factoring-common-core/resources/smsconfig.properties");

    private String sendUrl;//短信发送路径
    private String check;//短信接口校验地址
    private String checkUrl;//身份证件认证地址
    private String appkey;//银行卡认证key
    private String bankCardUrl;//银行卡认证地址
    private String sendMsgUrl;//腾讯云接口发送自定义信息
    private String sendSdkappid;//腾讯云接口sdkappid
    private String sendAppkey;//腾讯云接口appkey
    private String pwdModelCode;//密码发送模板id
    private String smsModelCode;//短信模板
    private String smsNationcode;//区号
    private String smsSign;//名称
    private String smsSendTxtype;//类型
    private String xytServer;//新业态推广师校验
    private String xytServerBd;//本地推广师校验
    private String ypApikey;//apikey
    private String ypUrl;//云片短信发送地址
    private String ph_detail_score_url;//调用普惠接口保存用户地址

    public String getSendUrl() {
        return initParams.getProperties().getProperty("sms.send.url");
    }

    public String getCheck() {
        return initParams.getProperties().getProperty("sms.code.check");
    }

    public String getCheckUrl() {
        return initParams.getProperties().getProperty("idcard.check.url");
    }

    public String getAppkey() {
        return initParams.getProperties().getProperty("appkey");
    }

    public String getBankCardUrl() {
        return initParams.getProperties().getProperty("bank.card.auth.url");
    }

    public String getSendMsgUrl() {
        return initParams.getProperties().getProperty("sms.send.msg.url");
    }

    public String getSendSdkappid() {
        return initParams.getProperties().getProperty("sms.send.sdkappid");
    }

    public String getSendAppkey() {
        return initParams.getProperties().getProperty("sms.send.appkey");
    }

    public String getPwdModelCode() {
        return initParams.getProperties().getProperty("pwd.model.code");
    }

    public String getSmsModelCode() {
        return initParams.getProperties().getProperty("sms.model.code");
    }

    public String getSmsNationcode() {
        return initParams.getProperties().getProperty("sms.nationcode");
    }

    public String getSmsSign() {
        return initParams.getProperties().getProperty("sms.sign");
    }

    public String getSmsSendTxtype() {
        return initParams.getProperties().getProperty("sms.send.txtype");
    }

    public String getXytServer() {
        return initParams.getProperties().getProperty("xyt_server");
    }

    public String getXytServerBd() {
        return initParams.getProperties().getProperty("xyt_server_bd");
    }

    public String getYpApikey() {
        return initParams.getProperties().getProperty("yp_apikey");
    }

    public String getYpUrl() {
        return initParams.getProperties().getProperty("yp_url");
    }

    public String getPh_detail_score_url() {
        return initParams.getProperties().getProperty("ph_detail_score_url");
    }
}
