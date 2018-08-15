package com.ph.shopping.facade.member.menum.bankcard;

/**
 * @version 2.1
 * @项目：factoring-parent
 * @描述： 会员银行卡操作日志枚举
 * @作者： 熊克文
 * @创建时间： 2017/5/26
 * @Copyright by xkw
 */
public enum MemberBankCardLogOperationTypeEnum {
    /**
     * 绑定
     */
    BIND_ED((byte) 1, "绑定"),
    /**
     * 解绑
     */
    UNBUNDLED((byte) 2, "解绑"),
    /**
     * 更新用户原绑定银行卡
     */
    UPDATE_BIND_ED((byte) 3, "更新用户原绑定银行卡");

    /**
     * 编码
     */
    private Byte code;
    /**
     * 描述
     */
    private String remark;

    MemberBankCardLogOperationTypeEnum(Byte code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
