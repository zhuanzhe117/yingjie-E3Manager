package com.lyj.e3manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyj.e3common.pojo.EasyUIDataGridResult;
import com.lyj.e3manager.dao.TbItemDao;
import com.lyj.e3manager.service.ItemService;
import com.lyj.e3manager.entity.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品管理Service
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemDao tbItemDao;

    @Override
    public TbItem getItemById(int itemId){
        // 根据主键查询
        TbItem item = tbItemDao.queryById(itemId);
        return  item;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows){
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询
        TbItem tbItem = new TbItem();
        List<TbItem> list = tbItemDao.queryAll(tbItem);
        //创建一个返回值对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        //取分页结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        //取总记录数
        long total = pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }
}
