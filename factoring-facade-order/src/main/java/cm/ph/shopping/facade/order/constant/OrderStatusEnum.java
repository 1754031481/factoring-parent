package cm.ph.shopping.facade.order.constant;

/**
 * 供应链订单枚举
 *
 * @author 郑朋
 * @create 2017/5/16
 **/
public enum OrderStatusEnum {
    /**
     * 待付款
     */
    UNPAID_ORDER((byte)0 ,"待付款 "),
    /**
     *待发货
     */
    UNDELIVERED_ORDER((byte)1 ,"待发货"),
    /**
     *待收货
     */
    RECEIVED_ORDER((byte)2 ,"待收货"),
    /**
     *交易完成
     */
    DONE_ORDER((byte)3 ,"交易完成"),
    /**
     *交易取消
     */
    CANCEL_ORDER((byte)4 ,"交易取消");

    private byte status;
    private String desc;

    OrderStatusEnum(byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public byte getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
