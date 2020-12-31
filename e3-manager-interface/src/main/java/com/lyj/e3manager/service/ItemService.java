package com.lyj.e3manager.service;


import com.lyj.e3common.pojo.EasyUIDataGridResult;
import com.lyj.e3manager.entity.TbItem;

public interface ItemService {

    TbItem getItemById(int itemId);

    EasyUIDataGridResult getItemList(int page, int rows);

}
