package com.lyj.e3manager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbContentCategory)实体类
 *
 * @author makejava
 * @since 2020-12-07 16:50:36
 */
public class TbContentCategory implements Serializable {
    private static final long serialVersionUID = -68408841225504105L;

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private int sortOrder;

    private boolean isParent;

    private Date created;

    private Date updated;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean parent) {
        isParent = parent;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}