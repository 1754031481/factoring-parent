package com.ph.shopping.facade.system.dto;



import com.ph.shopping.common.core.base.BaseValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 修改系统参数入参
 *
 * @author 郑朋
 * @create 2017/5/8
 **/
public class UpdateSystemParameterDTO extends BaseValidate {

    private static final long serialVersionUID = 7868440305464913376L;

    /**
     * id
     */
    @NotNull(message = "主键ID不能为空")
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
     * 操作人名称
     */
    @NotBlank(message = "操作人不能为空")
    private String operatorName;
    /**
     * 操作账号
     */
    @NotBlank(message = "操作人账号不能为空")
    private String operateAccount;
    /**
     * 操作人ID
     */
    @NotNull(message = "操作人ID不能为空")
    private Long operatorId;

    /**
     * 积分上限
     */
    private Double upperLimit;
    /**
     * 积分下限
     */
    private Double lowerLimit;

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

    public String getOperateAccount() {
        return operateAccount;
    }

    public void setOperateAccount(String operateAccount) {
        this.operateAccount = operateAccount;
    }

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

    @Override
    public String toString() {
        return "UpdateSystemParameterDTO{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                ", parameterValue=" + parameterValue +
                ", operatorName='" + operatorName + '\'' +
                ", operateAccount='" + operateAccount + '\'' +
                ", operatorId=" + operatorId +
                ", upperLimit=" + upperLimit +
                ", lowerLimit=" + lowerLimit +
                '}';
    }
}
