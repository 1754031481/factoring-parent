package com.ph.shopping.facade.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ph.shopping.common.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
  * Describe:
  * @param: 运费模板实体
  * @return:
  * @author 段维明
  * @Date 2018/3/20
  */
@Table(name = "alq_freight_templet")
public class FreightTemplet implements Serializable {

    @Id
    private Long id;

    @Column(name = "created_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;


    /**
     * 商品总额最小
     */
    @Column(name = "min_product_price")
    private Double minProductPrice;

    /**
     * 商品总额最大
     */
    @Column(name = "max_product_price")
    private Double maxProductPrice;

    /**
     * 重量
     */
    @Column(name = "weight")
    private Double weight;

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    /**
     * 增加重量
     */
    @Column(name = "add_weight")
    private Double addWeight;

    /**
     * 增加价格
     */
    @Column(name = "add_price")
    private Double addPrice;

    /**
     * 是否删除 0未提交数据 1删除 2已提交数据
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    @Override
    public String toString() {
        return "FreightTemplet{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", minProductPrice=" + minProductPrice +
                ", maxProductPrice=" + maxProductPrice +
                ", weight=" + weight +
                ", price=" + price +
                ", addWeight=" + addWeight +
                ", addPrice=" + addPrice +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
