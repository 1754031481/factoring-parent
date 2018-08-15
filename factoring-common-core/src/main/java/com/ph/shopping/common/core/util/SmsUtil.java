package com.ph.shopping.common.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ph.shopping.common.core.config.SmsConfig;
import com.ph.shopping.common.core.dto.*;
import com.ph.shopping.common.util.http.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author xwolf
 * @since 1.8
 **/
@Component
public class SmsUtil {

    private static  final String DEFAULT_ENCODING="UTF-8";

    private static Logger log = LoggerFactory.getLogger(SmsUtil.class);

    @Autowired
    private  SmsConfig smsConfig;

    private  Logger logger=LoggerFactory.getLogger(SmsUtil.class);


    /**
     * 快火App代理/业务员注册
     * @param registerDTO
     * @return
     */
    public  boolean sendRegisterMsg(RegisterDTO registerDTO){
        final String yi = "1";
        final String code ="code";
        log.info("代理商注册：{}", JSON.toJSON(registerDTO));
        String message = registerDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getAgentRegister(), BeanToMap.getMapByStr(registerDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("代理商注册content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }

    /**
     * 快火APP注册/找回密码操作发送验证码
     * @param findPasswordDTO
     * @return
     */
    public  boolean sendRegisterOrFindPasswordMsg(FindPasswordDTO findPasswordDTO){
        final String yi = "1";
        final String code ="code";
        log.info("用户注册/找回密码：{}", JSON.toJSON(findPasswordDTO));
        String message = findPasswordDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getPassword(), BeanToMap.getMapByStr(findPasswordDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("用户注册/找回密码content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }


    /**
     * 快火代理提醒
     * @param agentAlertDTO
     * @return
     */
    public  boolean sendAgentAlert(AgentAlertDTO agentAlertDTO){
        final String yi = "1";
        final String code ="code";
        log.info("快火代理提醒：{}", JSON.toJSON(agentAlertDTO));
        String message = agentAlertDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getAgentAlert(), BeanToMap.getMapByStr(agentAlertDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("快火代理提醒content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }

    /**
     * 现金/积分支付
     * @param cashDTO
     * @return
     */
    public  boolean sendCashMsg(CashDTO cashDTO){
        final String yi = "1";
        final String code ="code";
        log.info("现金/积分支付：{}", JSON.toJSON(cashDTO));
        String message = cashDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getCash(), BeanToMap.getMapByStr(cashDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("现金/积分支付content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }

    /**
     * 预定订单通知
     * @param prePayDTO
     * @return
     */
    public  boolean sendPrepayMsg(PrePayDTO prePayDTO){
        final String yi = "1";
        final String code ="code";
        log.info("预定订单通知：{}", JSON.toJSON(prePayDTO));
        String message = prePayDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getPrepay(), BeanToMap.getMapByStr(prePayDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("预定订单通知content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }

    /**
     * 订单支付通知
     * @param payDTO
     * @return
     */
    public  boolean sendPayMsg(PayDTO payDTO){
        final String yi = "1";
        final String code ="code";
        log.info("订单支付通知：{}", JSON.toJSON(payDTO));
        String message = payDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getPay(), BeanToMap.getMapByStr(payDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("订单支付通知content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }

    /**
     * 商户/会员推广奖金通知
     * @param spreadDTO
     * @return
     */
    public  boolean sendSpreadMsg(SpreadDTO spreadDTO){
        final String yi = "1";
        final String code ="code";
        log.info("推广奖金通知：{}", JSON.toJSON(spreadDTO));
        String message = spreadDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getSpread(), BeanToMap.getMapByStr(spreadDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("推广奖金content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }

    /**
     * 用户支付通知<通知商户>
     * @param memberPayDTO
     * @return
     */
    public  boolean sendMemberPay(MemberPayDTO memberPayDTO){
        final String yi = "1";
        final String code ="code";
        log.info("用户支付通知：{}", JSON.toJSON(memberPayDTO));
        String message = memberPayDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getMemberPay(), BeanToMap.getMapByStr(memberPayDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("用户支付通知content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }


    /**
     * 用户提交订单<通知商户>
     * @param submitOrderDTO
     * @return
     */
    public  boolean sendMemberSubmitOrder(SubmitOrderDTO submitOrderDTO){
        final String yi = "1";
        final String code ="code";
        log.info("用户提交订单通知：{}", JSON.toJSON(submitOrderDTO));
        String message = submitOrderDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getSubmitOrder(), BeanToMap.getMapByStr(submitOrderDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("用户提交订单通知content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }

    /**
     * 发送公共验证码
     * @param commonDTO
     * @return
     */
    public  boolean sendCommonMsg(CommonDTO commonDTO){

        final String yi = "1";
        final String code ="code";        log.info("公共验证码通知：{}", JSON.toJSON(commonDTO));
        String message = commonDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getCommon(), BeanToMap.getMapByStr(commonDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("公共验证码content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }


    /**
     * 取消订单
     * @param orderCancelDTO
     * @return
     */
    public  boolean cancelOrder(OrderCancelDTO orderCancelDTO){
        final String yi = "1";
        final String code ="code";
        log.info("取消订单通知：{}", JSON.toJSON(orderCancelDTO));
        String message = orderCancelDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getCancelOrder(), BeanToMap.getMapByStr(orderCancelDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("取消订单content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }



    /**
     * 验证 手机验证码
     * @param checkDTO
     * @return
     */
    public  boolean check(CheckDTO checkDTO){
        final String yi = "1";
        final String code ="code";
        log.info("验证码校验：{}", JSON.toJSON(checkDTO));
        String message = checkDTO.validateForm();
        if (Objects.nonNull(message)) {
            return Boolean.FALSE;
        }
        try {
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getCheck(), BeanToMap.getMapByStr(checkDTO), DEFAULT_ENCODING);
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("验证码校验content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }

    /**
     * 天易发送验证码
     * tenghui
     * @param params
     * @return
     */
    public  boolean sendMsg(Map<String, String> params){
        final String yi = "1";
        final String code ="code";
        log.info("用户注册/找回密码：{}", JSON.toJSON(params));
        try {
            String msgUrl = smsConfig.getSendMsg();//发送短信路径
            String url = msgUrl+"?phone="+params.get("phone")+"&codeType="+params.get("codeType")+"&modelId="+params.get("modelId")+"&signMsg="+params.get("signMsg")+"&sysFrom="+params.get("sysFrom")+"&ip="+params.get("ip");
            String sendGet = org.alqframework.net.html.HttpClientUtils.getHttpsToGet(url);

            JSONObject content = JSON.parseObject(sendGet);
            log.info("用户注册/找回密码content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }

    /**
     * 天易验证码校验
     * tenghui
     * @param params
     * @return
     */
    public  boolean checkMsg(Map<String, String> params){
        final String yi = "1";
        final String code ="code";
        log.info("验证码校验：{}", JSON.toJSON(params));
        try {
            log.info("验证验证码接口==>url：" + smsConfig.getCheckMsg());
            HttpResult httpResult = HttpClientUtils.sendPost(smsConfig.getCheckMsg(), params, DEFAULT_ENCODING);
            logger.info("天易发送验证码配置文件调用地址"+smsConfig.getCheckMsg());
            JSONObject content = JSONObject.parseObject(httpResult.getResponseContent());
            log.info("验证码校验content:{}",content.toJSONString());
            if (yi.equals(content.getString(code))){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
    }
}
