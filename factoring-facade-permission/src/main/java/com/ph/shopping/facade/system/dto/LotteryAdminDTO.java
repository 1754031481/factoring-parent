package com.ph.shopping.facade.system.dto;

import com.ph.shopping.common.core.base.BaseValidate;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 荐家跃
 * @Title: LotteryAdminVO
 * @Description: 奖项设置DTO
 * @date 2018/3/20 14:55
 * @Version:1.0.0
 */
public class LotteryAdminDTO  extends BaseValidate {
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建者ID
     */
    private Long createId;

    /**
     * 奖项名称
     */
    private String name;

    /**
     * 奖项金额
     */
    private Double price;

    /**
     * 奖项比例
     */
    private String scale;

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "LotteryAdminVO{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createId=" + createId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", scale='" + scale + '\'' +
                '}';
    }
}
