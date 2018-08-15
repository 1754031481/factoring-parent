package com.ph.shopping.facade.member.menum.message;
/**
 * 
 * @ClassName:  PushMessageEnum   
 * @Description:消息推送枚举   
 * @author: 李杰
 * @date:   2017年6月1日 下午3:36:52     
 * @Copyright: 2017
 */
public enum PushMessageEnum {

	/**
	 * 推送用户类型，会员
	 */
	MEMBER((byte)0,"推送用户类型，会员"),
	/**
	 * 推送用户类型，商户
	 */
	MERCHANT((byte)1,"推送用户类型，商户"),
	/**
	 * 推送成功
	 */
	PUSH_SUCCESS((byte)0,"推送成功"),
	/**
	 * 推送失败
	 */
	PUSH_FAIL((byte)1,"推送失败"),
	/**
	 * 消息已读
	 */
	READ((byte)1,"消息已读"),
	/**
	 * 消息未读
	 */
	UNREAD((byte)0,"消息未读"),
	/**
	 * 所有平台
	 */
	ALL((byte)0,"所有平台"),
	/**
	 * 安卓
	 */
	ANDROID((byte)1,"安卓"),
	/**
	 * ios
	 */
	IOS((byte)2,"ios")
	;
	/**
	 * code
	 */
	private Byte code;
	/**
	 * 描述
	 */
	private String desc;
	
	PushMessageEnum (Byte code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public Byte getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
