package com.ph.shopping.facade.permission.entity;

import com.ph.shopping.common.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @项目：factoring-facade-permission
 * @描述： 菜单按钮实体
 * @作者： Mr.Shu
 * @创建时间：2017-05-12
 * @Copyright @2017 by Mr.Shu
 */
@Table(name = "ph_permission_role_menu")
public class MenuBtn extends BaseEntity {

    private static final long serialVersionUID = 8355710622359264368L;

    /**
     * 菜单id
     */
    @Column(name = "menuId")
    private Long menuId;

    /**
     * 按钮id
     */
    @Column(name = "btnId")
    private Long btnId;

    /**
     * 角色id
     */
    @Column(name = "roleId")
    private Long roleId;

    /**
     * 排序
     */
    @Column(name = "sequence")
    private Integer sequence;


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getBtnId() {
        return btnId;
    }

    public void setBtnId(Long btnId) {
        this.btnId = btnId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
