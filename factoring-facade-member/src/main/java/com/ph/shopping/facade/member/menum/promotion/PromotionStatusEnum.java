package com.ph.shopping.facade.member.menum.promotion;

/**
 * 
 * factoring-facade-member
 *
 * @description：服务专员审核状态
 *
 * @author：liuy
 *
 * @createTime：2017年5月24日
 *
 * @Copyright @2017 by liuy
 */
public enum PromotionStatusEnum {

	/**
	 * 服务专员待审核
	 */
    PROMOTION_AUDIT((byte) 0, "服务专员待审核"),
	/**
	 * 服务专员审核通过
	 */
    PROMOTION_ADOPT((byte) 1, "服务专员审核通过"),
	/**
	 * 服务专员审核未通过
	 */
    PROMOTION_FAIL((byte) 2, "服务专员审核未通过"),
	/**
	 * 服务专员不分润
	 */
    PROMOTION_NOT_PROFIT((byte) 3, "服务专员不分润");
    
    /**
	 * 编码
	 */
	private Byte code;
	/**
	 * 描述
	 */
	private String remark;
	
	private PromotionStatusEnum(Byte code,String remark){
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
