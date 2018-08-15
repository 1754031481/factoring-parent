/**  
 * @Title:  LogisticsVO.java   
 * @Package com.ph.shopping.facade.system.vo   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 李杰    
 * @date:   2017年6月13日 下午10:59:27   
 * @version V1.0 
 * @Copyright: 2017
 */  
package com.ph.shopping.facade.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
  * Describe:FreightVO
  * @param:
  * @return:
  * @author 段维明
  * @Date 2018/3/20
  */
public class FreightVO implements Serializable{

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 商品总额最小
	 */
	private Double minProductPrice;

	/**
	 * 商品总额最大
	 */
	private Double maxProductPrice;



	/**
	 * 重量
	 */
	private Double weight;

	/**
	 * 价格
	 */
	private Double price;

	/**
	 * 增加重量
	 */
	private Double addWeight;

	/**
	 * 增加价格
	 */
	private Double addPrice;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMinProductPrice() {
		return minProductPrice;
	}

	public void setMinProductPrice(Double minProductPrice) {
		this.minProductPrice = minProductPrice;
	}

	public Double getMaxProductPrice() {
		return maxProductPrice;
	}

	public void setMaxProductPrice(Double maxProductPrice) {
		this.maxProductPrice = maxProductPrice;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAddWeight() {
		return addWeight;
	}

	public void setAddWeight(Double addWeight) {
		this.addWeight = addWeight;
	}

	public Double getAddPrice() {
		return addPrice;
	}

	public void setAddPrice(Double addPrice) {
		this.addPrice = addPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonFormat(pattern= "yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "FreightVO{" +
				"id=" + id +
				", minProductPrice=" + minProductPrice +
				", maxProductPrice=" + maxProductPrice +
				", weight=" + weight +
				", price=" + price +
				", addWeight=" + addWeight +
				", addPrice=" + addPrice +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}
