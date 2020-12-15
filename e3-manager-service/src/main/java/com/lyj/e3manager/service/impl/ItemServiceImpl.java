package com.lyj.e3manager.service.impl;

import com.lyj.e3manager.dao.TbItemDao;
import com.lyj.e3manager.service.ItemService;
import com.lyj.e3manager.entity.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品管理Service
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemDao itemMapper;

    @Override
    public TbItem getItemById(int itemId){
        // 根据主键查询
        TbItem item = itemMapper.queryById(itemId);
        return  item;
    }
}
