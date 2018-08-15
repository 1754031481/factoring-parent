package com.ph.shopping.facade.system.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 刘海洋
 * @Title: PrizePool
 * @Description: 奖池实体
 * @date 2018/3/20 14:09
 * @Version:1.0.0
 */
@Table(name = "alq_prize_pool")
public class PrizePool {

    @Id
    private Long id;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;

    @Column(name = "createdId")
    private Long createdId;

    /**
     * 开奖周期开始时间
     */
    @Column(name = "lotteryStartTime")
    private Date lotteryStartTime;

    /**
     * 开奖周期结束时间
     */
    @Column(name = "lotteryEndTime")
    private Date lotteryEndTime;

    /**
     * 奖券数
     */
    @Column(name = "lotteryNum")
    private Long lotteryNum;

    /**
     * 订单总金额
     */
    @Column(name = "orderPrice")
    private Long orderPrice;

    /**
     * 奖池总金额
     */
    @Column(name = "prizePoolPrice")
    private Long prizePoolPrice;

    /**
     * 是否开奖0:未开奖1:已开奖
     */
    @Column(name = "status")
    private Long status;

    /**
     * 开奖时间
     */
    @Column(name = "lotteryOpenTime")
    private Date lotteryOpenTime;

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

    public Long getCreatedId() {
        return createdId;
    }

    public void setCreatedId(Long createdId) {
        this.createdId = createdId;
    }

    public Date getLotteryStartTime() {
        return lotteryStartTime;
    }

    public void setLotteryStartTime(Date lotteryStartTime) {
        this.lotteryStartTime = lotteryStartTime;
    }

    public Date getLotteryEndTime() {
        return lotteryEndTime;
    }

    public void setLotteryEndTime(Date lotteryEndTime) {
        this.lotteryEndTime = lotteryEndTime;
    }

    public Long getLotteryNum() {
        return lotteryNum;
    }

    public void setLotteryNum(Long lotteryNum) {
        this.lotteryNum = lotteryNum;
    }

    public Long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Long getPrizePoolPrice() {
        return prizePoolPrice;
    }

    public void setPrizePoolPrice(Long prizePoolPrice) {
        this.prizePoolPrice = prizePoolPrice;
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

    @Override
    public String toString() {
        return "PrizePool{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createdId=" + createdId +
                ", lotteryStartTime=" + lotteryStartTime +
                ", lotteryEndTime=" + lotteryEndTime +
                ", lotteryNum=" + lotteryNum +
                ", orderPrice=" + orderPrice +
                ", prizePoolPrice=" + prizePoolPrice +
                ", status=" + status +
                ", lotteryOpenTime=" + lotteryOpenTime +
                '}';
    }
}
