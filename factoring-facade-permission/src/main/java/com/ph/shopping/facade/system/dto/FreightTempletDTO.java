/**  
 * @Title:  LogisticsDTO.java   
 * @Package com.ph.shopping.facade.system.dto   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 李杰    
 * @date:   2017年6月13日 下午10:53:27   
 * @version V1.0 
 * @Copyright: 2017
 */  
package com.ph.shopping.facade.system.dto;

import com.ph.shopping.common.core.base.BaseValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
  * Describe:FreightTempletDTO
  * @param:
  * @return:
  * @author 段维明
  * @Date 2018/3/20
  */
public class FreightTempletDTO extends BaseValidate {

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */
	private static final long serialVersionUID = -1764883642297620533L;
	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 商品总额最小
	 */
	@NotNull(message = "商品总额最小不能为空")
	private Double minProductPrice;

	/**
	 * 商品总额最大
	 */
	private Double maxProductPrice;


	/**
	 * 重量
	 */
	@NotNull(message = "重量不能为空")
	private Double weight;

	/**
	 * 价格
	 */
	@NotNull(message = "价格不能为空")
	private Double price;

	/**
	 * 增加重量
	 */
	@NotNull(message = "增加重量不能为空")
	private Double addWeight;

	/**
	 * 增加价格
	 */
	@NotNull(message = "增加价格不能为空")
	private Double addPrice;

	private Long createrId;

	public Long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Long createdId) {
		this.createrId = createdId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "FreightTempletDTO{" +
				"id=" + id +
				", minProductPrice=" + minProductPrice +
				", maxProductPrice=" + maxProductPrice +
				", weight=" + weight +
				", price=" + price +
				", addWeight=" + addWeight +
				", addPrice=" + addPrice +
				", createrId=" + createrId +
				'}';
	}
}
