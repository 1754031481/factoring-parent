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
 * @描述： 角色实体类
 * @作者： Mr.Shu
 * @创建时间：2017-05-12
 * @Copyright @2017 by Mr.Shu
 */
@Table(name = "ph_permission_role")
public class Role  implements Serializable{

    private static final long serialVersionUID = 7375175379375246073L;

    /**
     * 角色名称
     */
    @Column(name = "roleName")
    private String roleName;


    /**
     * 角色编号
     */
    @Column(name = "roleCode")
    private Byte roleCode;


    /**
     * 角色状态 0 ：启用 1：停用
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 角色类型 0 店铺 1 管理员
     */
    private int type;

    /**
     * 角色描述
     */
    @Column(name = "description")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "createTime")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "updateTime")
    private Date updateTime;

    @Column(name = "createrId")
    private Long createrId;

    @Column(name = "updaterId")
    private Long updaterId;

    @Id
    private Long id;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Date getCreateTime() {
        return createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Byte getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Byte roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
