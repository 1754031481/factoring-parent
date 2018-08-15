package com.ph.shopping.facade.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 荐家跃
 * @Title: LotteryAdminVO
 * @Description: 奖项设置VO
 * @date 2018/3/20 14:55
 * @Version:1.0.0
 */
public class LotteryAdminVO implements Serializable {
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
    private Date createId;

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

    /**
     * 当前比例
     */
    private Integer nowScale;

    /**
     * Double类型的奖项比例
     */
    private Double newScale;

    /***
     * 订单总金额
     */
    private Long orderSumPrice;

    /**
     * 是否开奖0:未开奖1:已开奖
     */
    private Long status;

    /**
     * 开奖时间
     */
    private Date lotteryOpenTime;

    /**
     * 奖池金额
     */
    private Long prizePoolPrice;

    public Long getPrizePoolPrice() {
        return prizePoolPrice;
    }

    public void setPrizePoolPrice(Long prizePoolPrice) {
        this.prizePoolPrice = prizePoolPrice;
    }

    public Long getOrderSumPrice() {
        return orderSumPrice;
    }

    public void setOrderSumPrice(Long orderSumPrice) {
        this.orderSumPrice = orderSumPrice;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getLotteryOpenTime() {
        return lotteryOpenTime;
    }

    public void setLotteryOpenTime(Date lotteryOpenTime) {
        this.lotteryOpenTime = lotteryOpenTime;
    }

    private Long lotteryNum;

    public Long getLotteryNum() {
        return lotteryNum;
    }

    public void setLotteryNum(Long lotteryNum) {
        this.lotteryNum = lotteryNum;
    }

    public Double getNewScale() {
        return newScale;
    }

    public void setNewScale(Double newScale) {
        this.newScale = newScale;
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

    public Integer getNowScale() {
        return nowScale;
    }

    public void setNowScale(Integer nowScale) {
        this.nowScale = nowScale;
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
                ", nowScale='" + nowScale + '\'' +
                '}';
    }
}
