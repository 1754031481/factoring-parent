package com.ph.shopping.facade.system.vo;

import java.io.Serializable;

/**
 * 系统参数VO
 *
 * @author 郑朋
 * @create 2017/5/8
 **/
public class SystemParameterVO implements Serializable {

    private static final long serialVersionUID = -7276329604495810054L;

    /**
     * id
     */
    private Long id;

    /**
     * 参数备注
     */
    private String remark;
    /**
     * 参数值
     */
    private Double parameterValue;

    /**
     * 参数名称
     */
    private String parameterName;
    /**
     * 是否可以修改（0、不能修改 1、可以修改）
     */
    private Byte isUpdate;
    /**
     * 是否开启，0是已开启，1是未开启
     */
    private Integer type;
    /**
     * 积分上限
     */
    private Double upperLimit;
    /**
     * 积分下限
     */
    private Double lowerLimit;
    /**
     * 是否开启积分比例
     */
    private Long integratedState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(Double parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Byte getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Byte isUpdate) {
        this.isUpdate = isUpdate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Long getIntegratedState() {
        return integratedState;
    }

    public void setIntegratedState(Long integratedState) {
        this.integratedState = integratedState;
    }

    @Override
    public String toString() {
        return "SystemParameterVO{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                ", parameterValue=" + parameterValue +
                ", parameterName='" + parameterName + '\'' +
                ", isUpdate=" + isUpdate +
                ", type=" + type +
                ", upperLimit=" + upperLimit +
                ", lowerLimit=" + lowerLimit +
                ", integratedState=" + integratedState +
                '}';
    }
}
