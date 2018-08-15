package com.ph.shopping.facade.system.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 刘海洋
 * @Title: lotteryAdmin
 * @Description: 奖项设置实体
 * @date 2018/3/20 11:15
 * @Version:1.0.0
 */
@Table(name = "alq_lottery_admin")
public class lotteryAdmin implements Serializable{

    @Id
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "updateTime")
    private Date updateTime;

    /**
     * 创建者ID
     */
    @Column(name = "createId")
    private Date createId;

    /**
     * 奖项名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 奖项金额
     */
    @Column(name = "price")
    private Long price;

    /**
     * 奖项比例
     */
    @Column(name = "scale")
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

    public Date getCreateId() {
        return createId;
    }

    public void setCreateId(Date createId) {
        this.createId = createId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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
        return "lotteryAdmin{" +
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
