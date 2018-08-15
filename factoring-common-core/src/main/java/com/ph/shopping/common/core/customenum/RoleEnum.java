package com.ph.shopping.common.core.customenum;

import java.util.Objects;

/**
 * @项目：factoring-facade-permission
 * @描述： 角色编号枚举
 * @作者： Mr.zheng
 * @创建时间：2017-03-14
 * @Copyright @2017 by Mr.zheng
 */
public enum RoleEnum {
    /**
     * 管理员
     */
    ADMIN((byte) 1, "管理员"),
    /**
     * 供应商
     */
    SUPPLIER((byte) 2, "供应商"),
    /**
     *市级代理商
     */
    CITY_AGENT((byte) 3, "市级代理商"),
    /**
     *县级代理商
     */
    COUNTY_AGENT((byte) 4, "县级代理商"),
    /**
     *社区代理商
     */
    COMMUNITY_AGENT((byte) 5, "社区代理商"),
    /**
     *商户
     */
    MERCHANT((byte) 6, "商户"),;

    RoleEnum(Byte code, String message) {
        this.code = code;
        this.message = message;
    }

    private Byte code;
    private String message;

    public Byte getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static RoleEnum getRoleEnumByCode(Byte code) {
        RoleEnum[] roleEnums =  RoleEnum.values();
        for (RoleEnum roleEnum : roleEnums) {
            if (Objects.equals(code, roleEnum.code)) {
                return roleEnum;
            }
        }
        return null;
    }


}
