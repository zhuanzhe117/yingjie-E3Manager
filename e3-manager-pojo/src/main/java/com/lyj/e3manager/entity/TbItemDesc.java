package com.lyj.e3manager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbItemDesc)实体类
 *
 * @author makejava
 * @since 2020-12-07 16:52:21
 */
public class TbItemDesc implements Serializable {
    private static final long serialVersionUID = 241826016675316600L;

    private Integer itemId;

    private Date created;

    private Date updated;

    private String itemDesc;


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

}