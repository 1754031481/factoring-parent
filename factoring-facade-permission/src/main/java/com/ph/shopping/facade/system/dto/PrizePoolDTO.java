package com.ph.shopping.facade.system.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 刘海洋
 * @Title: PrizePoolDTO
 * @Description: 奖池DTO
 * @date 2018/3/20 14:23
 * @Version:1.0.0
 */
public class PrizePoolDTO implements Serializable{

    /**
     * 奖期
     */
    private Long id;

    /**
     * 开奖周期开始时间
     */
    private String lotteryStartTime;

    /**
     * 开奖周期结束时间
     */
    private String lotteryEndTime;

    /**
     * 开奖周期开始时间
     */
    private Date StartTime;

    /**
     * 开奖周期结束时间
     */
    private Date EndTime;

    /**
     * 奖券数
     */
    private Long lotteryNum;

    /**
     * 订单总金额
     */
    private Long orderPrice;

    /**
     * 奖池总金额
     */
    private Long prizePoolPrice;

    /**
     * 是否开奖0:未开奖1:已开奖
     */
    private Long status;

    /**
     * 开奖时间
     */
    private String lotteryOpenTime;

    /**
     * 开奖时间
     */
    private Date OpenTime;

    /**
     * 奖项名称
     */
    private String prizeName;

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Date getOpenTime() {
        return OpenTime;
    }

    public void setOpenTime(Date openTime) {
        OpenTime = openTime;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLotteryStartTime() {
        return lotteryStartTime;
    }

    public void setLotteryStartTime(String lotteryStartTime) {
        this.lotteryStartTime = lotteryStartTime;
    }

    public String getLotteryEndTime() {
        return lotteryEndTime;
    }

    public void setLotteryEndTime(String lotteryEndTime) {
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

    public String getLotteryOpenTime() {
        return lotteryOpenTime;
    }

    public void setLotteryOpenTime(String lotteryOpenTime) {
        this.lotteryOpenTime = lotteryOpenTime;
    }

    @Override
    public String toString() {
        return "PrizePoolDTO{" +
                "id=" + id +
                ", lotteryStartTime='" + lotteryStartTime + '\'' +
                ", lotteryEndTime='" + lotteryEndTime + '\'' +
                ", StartTime=" + StartTime +
                ", EndTime=" + EndTime +
                ", lotteryNum=" + lotteryNum +
                ", orderPrice=" + orderPrice +
                ", prizePoolPrice=" + prizePoolPrice +
                ", status=" + status +
                ", lotteryOpenTime='" + lotteryOpenTime + '\'' +
                ", OpenTime=" + OpenTime +
                ", prizeName='" + prizeName + '\'' +
                '}';
    }
}
