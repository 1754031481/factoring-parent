package com.ph.shopping.common.core.customenum;

/**
 * 
* @ClassName: MessageEnum
* @Description: TODO(用于猎头分润)
* @author Mr.Dong
* @date 2017年6月2日 下午2:38:18
 */
public enum MessageEnum {
	/**
	 * 成功
	 */
	SUCCESS(200, "成功"),
	/**
	 *服务器异常
	 */
	EXCEPTION(500,"服务器异常"),
	/**
	 *服务器无法回应
	 */
	NO_RESOURCE(400,"服务器无法回应"),
	/**
	 *参数不能为空
	 */
	NO_PARAM(10001,"参数不能为空"),
	/**
	 *未查询到区域数据
	 */
	NO_POSITION(10002,"未查询到区域数据"),
	/**
	 *通过区域未获取代理数据
	 */
	NO_AGENT_BY_POSITION(10003,"通过区域未获取代理数据"),
	/**
	 *请传入正确的猎头来源参数
	 */
	NO_CORRECT_FROMSYS(10004,"请传入正确的猎头来源参数");
	
	private MessageEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
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
