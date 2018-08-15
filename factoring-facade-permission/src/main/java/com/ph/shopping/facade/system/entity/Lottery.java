package com.ph.shopping.facade.system.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 刘海洋
 * @Title: Lottery
 * @Description: 奖券实体
 * @date 2018/3/20 11:22
 * @Version:1.0.0
 */
@Table(name = "alq_lottery")
public class Lottery implements Serializable{

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
    private Long createId;

    /**
     * 奖励金额
     */
    @Column(name = "lotteryPrice")
    private Long lotteryPrice;

    /**
     * 订单总额
     */
    @Column(name = "total_price")
    private Long totalPrice;

    /**
     * 创建者ID
     */
    @Column(name = "lotteryAdminId")
    private Long lotteryAdminId;

    /**
     * 关联的memberID
     */
    @Column(name = "memberId")
    private Long memberId;

    /**
     * 是否开奖0:未开  1:已开
     */
    @Column(name = "type")
    private Long type;

    /**
     * 关联的主订单号
     */
    @Column(name = "orderNum")
    private String orderNum;

    /**
     * 券号
     */
    @Column(name = "num")
    private Long num;

    /**
     * 红包数量
     */
    @Column(name = "red_packet_num")
    private Long packetNum;

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

    public Long getLotteryPrice() {
        return lotteryPrice;
    }

    public void setLotteryPrice(Long lotteryPrice) {
        this.lotteryPrice = lotteryPrice;
    }

    public Long getLotteryAdminId() {
        return lotteryAdminId;
    }

    public void setLotteryAdminId(Long lotteryAdminId) {
        this.lotteryAdminId = lotteryAdminId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getPacketNum() {
        return packetNum;
    }

    public void setPacketNum(Long packetNum) {
        this.packetNum = packetNum;
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createId=" + createId +
                ", lotteryPrice=" + lotteryPrice +
                ", totalPrice=" + totalPrice +
                ", lotteryAdminId=" + lotteryAdminId +
                ", memberId=" + memberId +
                ", type=" + type +
                ", orderNum='" + orderNum + '\'' +
                ", num=" + num +
                ", packetNum=" + packetNum +
                '}';
    }
}
