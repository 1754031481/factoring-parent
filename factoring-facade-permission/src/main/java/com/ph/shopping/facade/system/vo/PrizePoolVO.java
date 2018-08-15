package com.ph.shopping.facade.system.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 刘海洋
 * @Title: PrizePoolVO
 * @Description: 奖池VO
 * @date 2018/3/20 15:04
 * @Version:1.0.0
 */
public class PrizePoolVO implements Serializable{

    /**
     * 奖期
     */
    private Long id;

    /**
     * 开奖周期开始时间
     */
    private Date lotteryStartTime;

    /**
     * 开奖周期结束时间
     */
    private Date lotteryEndTime;

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
    private Date lotteryOpenTime;

    /***
     * 订单总金额
     */
    private Long orderSumPrice;

    /***
     * 奖池总金额
     */
    private Long PrizeSumPrice;

    /**
     * 开奖周期开始时间
     */
    private String StartTime;

    /**
     * 开奖周期结束时间
     */
    private String EndTime;

    /**
     * 上一次结束时间
     */
    private Date lastEndTime;

    /**
     * 奖项名称
     */
    private String prizeName;

    /**
     * 奖项金额
     */
    private Long prizePrice;

    /**
     * 用户姓名
     */
    private String memberName;

    /**
     * 手机号
     */
    private String phone;

    /**
     *券号
     */
    private String num;

    /**
     *订单编号集合
     */
    private String orderNo;

    /**
     *奖项金额
     */
    private Double lotteryPrice;

    /**
     *开奖参数值
     */
    private Long parameterValue;

    /**
     * 奖项金额
     */
    private Double prizePriceForDouble;

    public Double getPrizePriceForDouble() {
        return prizePriceForDouble;
    }

    public void setPrizePriceForDouble(Double prizePriceForDouble) {
        this.prizePriceForDouble = prizePriceForDouble;
    }

    public Long getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(Long parameterValue) {
        this.parameterValue = parameterValue;
    }

    public Double getLotteryPrice() {
        return lotteryPrice;
    }

    public void setLotteryPrice(Double lotteryPrice) {
        this.lotteryPrice = lotteryPrice;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Long getPrizePrice() {
        return prizePrice;
    }

    public void setPrizePrice(Long prizePrice) {
        this.prizePrice = prizePrice;
    }

    public Date getLastEndTime() {
        return lastEndTime;
    }

    public void setLastEndTime(Date lastEndTime) {
        this.lastEndTime = lastEndTime;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    private List<PrizePoolVO> prizePoolVOS;

    public List<PrizePoolVO> getPrizePoolVOS() {
        return prizePoolVOS;
    }

    public void setPrizePoolVOS(List<PrizePoolVO> prizePoolVOS) {
        this.prizePoolVOS = prizePoolVOS;
    }

    public Long getOrderSumPrice() {
        return orderSumPrice;
    }

    public void setOrderSumPrice(Long orderSumPrice) {
        this.orderSumPrice = orderSumPrice;
    }

    public Long getPrizeSumPrice() {
        return PrizeSumPrice;
    }

    public void setPrizeSumPrice(Long prizeSumPrice) {
        PrizeSumPrice = prizeSumPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "PrizePoolVO{" +
                "id=" + id +
                ", lotteryStartTime=" + lotteryStartTime +
                ", lotteryEndTime=" + lotteryEndTime +
                ", lotteryNum=" + lotteryNum +
                ", orderPrice=" + orderPrice +
                ", prizePoolPrice=" + prizePoolPrice +
                ", status=" + status +
                ", lotteryOpenTime=" + lotteryOpenTime +
                ", orderSumPrice=" + orderSumPrice +
                ", PrizeSumPrice=" + PrizeSumPrice +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", lastEndTime=" + lastEndTime +
                ", prizeName='" + prizeName + '\'' +
                ", prizePrice=" + prizePrice +
                ", memberName='" + memberName + '\'' +
                ", phone='" + phone + '\'' +
                ", num='" + num + '\'' +
                ", prizePoolVOS=" + prizePoolVOS +
                '}';
    }
}
