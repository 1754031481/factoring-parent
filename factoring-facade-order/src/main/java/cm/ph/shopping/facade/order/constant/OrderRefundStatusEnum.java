package cm.ph.shopping.facade.order.constant;

/**
 * 子订单退款状态枚举
 *
 * @author 郑朋
 * @create 2017/5/18
 **/
public enum OrderRefundStatusEnum {
    /**
     * 待审核
     */
    CHECKING((byte)0,"待审核"),
    /**
     *退款中
     */
    REFUNDING((byte)1,"退款中"),
    /**
     *退款完成
     */
    DONE_REFUND((byte)2,"退款完成"),
    /**
     *退款取消
     */
    CANCEL_REFUND((byte)3,"退款取消");

    private byte status;
    private String desc;

    OrderRefundStatusEnum(byte status, String desc) {
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
