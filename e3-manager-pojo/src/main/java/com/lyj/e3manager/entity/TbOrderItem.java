package com.lyj.e3manager.entity;

import java.io.Serializable;

/**
 * (TbOrderItem)实体类
 *
 * @author makejava
 * @since 2020-12-07 16:54:03
 */
public class TbOrderItem implements Serializable {
    private static final long serialVersionUID = -20238073867689834L;

    private String id;

    private String itemId;

    private String num;

    private String title;

    private String price;

    private String totalFee;

    private String picPath;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

}