/**
 *
 */
package com.ph.shopping.common.core.base;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.util.*;

/**
 * @项目：factoring-common-core
 * @描述：实体base类
 * @作者： Mr.chang
 * @创建时间：2017年3月8日
 * @Copyright @2017 by Mr.chang
 */
public class BaseEntity implements Serializable {

    public final static String[] BASE_FIELD_STRINGS = new String[]{"id", "createrId", "createTime", "updateTime"};
    /**
     *
     */
    private static final long serialVersionUID = -5300113985007593228L;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    @Id
    private Long id;

//    private Long updaterId;
//
//    public Long getUpdaterId() {
//        return updaterId;
//    }
//
//    public void setUpdaterId(Long updaterId) {
//        this.updaterId = updaterId;
//    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    //private Long createrId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 验证FormBean
     * @return
     */
    public List<String> validateForm() {
        List<String> errorList = null;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<BaseEntity>> constraintViolation = validator.validate(this);
        if (constraintViolation.size() > 0) {
            errorList = new ArrayList<String>(constraintViolation.size());
        }
        for (ConstraintViolation<BaseEntity> violation : constraintViolation) {
            errorList.add(violation.getMessage());
        }
        return errorList;
    }

    public void basic(Long userId) {
        if (Objects.nonNull(userId)) {
            Date date = new Date();
            /*if (Objects.isNull(this.getCreaterId())) {
                this.setCreaterId(userId);
            }*/
            if (Objects.isNull(this.getCreatedTime())) {
                this.setCreatedTime(date);
            }
           // this.setUpdaterId(userId);
            this.setUpdateTime(date);
        }
    }
}
