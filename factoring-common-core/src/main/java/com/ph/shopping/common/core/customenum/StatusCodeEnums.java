package com.ph.shopping.common.core.customenum;

/**
 * @author Xuejizheng
 * @date 2017-02-28 15:32
 * @see
 * @since 1.8
 */
public enum StatusCodeEnums {
    /**
     * 成功
     */
    SUCCESS(1,"成功"),
    /**
     * 没有数据
     */
    SUCCESS_NO_DATA(2,"没有数据"),
    /**
     * 用户信息异常
     */
    USER_INFO_ERROR(3,"用户信息异常"),
    /**
     *接口调用失败
     */
    ERROR(0,"接口调用失败"),
    /**
     *参数异常
     */
    ERROR_PARAM(-1,"参数异常");

     StatusCodeEnums(int code,String msg){
           this.code=code;
           this.msg=msg;
    }
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
