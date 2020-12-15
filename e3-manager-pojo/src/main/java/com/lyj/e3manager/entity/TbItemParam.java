package com.lyj.e3manager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbItemParam)实体类
 *
 * @author makejava
 * @since 2020-12-07 16:52:41
 */
public class TbItemParam implements Serializable {
    private static final long serialVersionUID = 468082250344667532L;

    private Integer id;

    private Integer itemCatId;

    private Date created;

    private Date updated;

    private String paramData;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Integer itemCatId) {
        this.itemCatId = itemCatId;
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

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

}