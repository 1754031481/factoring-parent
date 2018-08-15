package com.ph.shopping.common.core.customenum;

/**
 * @author : tenghui
 * @description ：支付枚举
 * @Creation Date ： 2018/4/11 12:51
 */
public enum CashierEnum {

    /**
     * 商户余额异常
     */
    MERCHENT_BALANCE("0","商户余额异常"),
    /**
     * 商户余额不足
     */
    MERCHENT_BALANCE_INSUFFICIENT("1","商户余额不足"),
    /**
     * 未开启积分支付
     */
    UNOPENED_SCORE("2","未开启积分支付"),
    /**
     * 支付码已过期
     */
    BAR_CODE_PASS("3","支付码已过期"),
    /**
     * 请用本人支付码支付
     */
    USE_ONESELF("4","请用本人支付码支付"),
    /**
     * 用户不存在
     */
    ON_ONE("5","用户不存在"),
    /**
     * 该用户不支持积分支付
     */
    ON_BAR_CODE_PAY("6","该用户不支持积分支付"),
    /**
     * 积分支付失败
     */
    SCORE_PAY_FAIL("7","积分支付失败"),
    /**
     * 用户余额异常
     */
    MEMBER_BALANCE("8","用户余额异常"),
    /**
     * 用户余额不足
     */
    MEMBER_BALANCE_INSUFFICIENT("9","用户余额不足");
    /**
     * 标识值:状态
     */
    private String code;
    /**
     *标识描述信息
     */
    private String msg;

    CashierEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
