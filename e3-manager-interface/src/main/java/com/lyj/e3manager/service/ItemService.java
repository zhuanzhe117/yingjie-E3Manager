package com.lyj.e3manager.service;


import com.lyj.e3common.pojo.EasyUIDataGridResult;
import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.entity.TbItem;
import com.lyj.e3manager.entity.TbItemDesc;

public interface ItemService {

    TbItem getItemById(int itemId);

    EasyUIDataGridResult getItemList(int page, int rows);

    E3Result addItem(TbItem item,String desc);

    TbItemDesc getItemDescById(long itemId);
}
