package com.vah.rakeup.domain;

/**
 * 用户权限
 */
public class UserPermission {
    // id
    private Long id;
    // 权限码
    private String code;
    // 权限说明
    private String comment;
    // 父级id
    private Long parentId;

    public UserPermission() {
    }

    public UserPermission(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
