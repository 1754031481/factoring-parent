package com.ph.shopping.common.core.customenum;

/**
 * 
* @ClassName: OuterResultEnum  
* @Description: 供外部调用返回状态码
* @author lijie  
* @date 2017年3月25日  
*
 */
public enum OuterResultEnum {

	/**
	 * 成功
	 */
	SUCCESS("1", "成功"),
	/**
	 * 用户不存在
	 */
	USER_NOEXISTS("0", "用户不存在"),
	/**
	 * 参数不全
	 */
	DATA_NOTALL("-1", "参数不全"),
	/**
	 * 参数不全
	 */
	PWD_ERROR("2","参数不全"),
	/**
	 * 用户处于冻结状态
	 */
	FROZEN("4","用户处于冻结状态"),
	/**
	 * 服务器错误
	 */
	SERVER_ERROR("3", "服务器错误");
	
	/**
	 * 状态码
	 */
	private String code;
	/**
	 * 描述
	 */
	private String msg;
	
	OuterResultEnum(String code,String msg){
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
