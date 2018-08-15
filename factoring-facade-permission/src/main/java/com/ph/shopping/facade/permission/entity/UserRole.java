package com.ph.shopping.facade.permission.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ph.shopping.common.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @项目：factoring-facade-permission
 *
 * @描述： 用户角色实体
 *
 * @作者： Mr.Shu
 *
 * @创建时间：2017-05-12
 *
 * @Copyright @2017 by Mr.Shu
 */
@Table(name = "ph_permission_user_role")
public class UserRole implements Serializable{

    private static final long serialVersionUID = -6782858999602872500L;
    /**
     * 角色id
     */
    @Column(name = "roleId")
    private Long roleId;

    /**
     * 用户id
     */
    @Column(name = "userId")
    private Long userId;

    @Column(name = "createrId")
    private Long createrId;

    @Column(name = "updaterId")
    private Long updaterId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name="createTime")
    private Date createdTime;

    @Id
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "updateTime")
    private Date updateTime;



    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public Long getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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
}
