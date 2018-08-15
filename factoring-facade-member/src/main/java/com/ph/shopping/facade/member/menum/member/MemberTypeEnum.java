package com.ph.shopping.facade.member.menum.member;
/**
 * 
 * factoring-facade-member
 *
 * @description：会员类型枚举
 *
 * @author：liuy
 *
 * @createTime：2017年5月24日
 *
 * @Copyright @2017 by liuy
 */
public enum MemberTypeEnum {

	/**
	 * 会员
	 */
	MEMBER_TYPE((byte)0,"会员"),
	/**
	 * 猎头
	 */
	HUNTER_TYPE((byte)1,"猎头");
	
    /**
	 * 编码
	 */
	private Byte code;
	/**
	 * 描述
	 */
	private String remark;
	private MemberTypeEnum(Byte code, String remark) {
		this.code = code;
		this.remark = remark;
	}
	public Byte getCode() {
		return code;
	}
	public void setCode(Byte code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
