package com.lyj.e3manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyj.e3common.pojo.EasyUIDataGridResult;
import com.lyj.e3common.utils.E3Result;
import com.lyj.e3common.utils.IDUtils;
import com.lyj.e3manager.dao.TbItemDao;
import com.lyj.e3manager.dao.TbItemDescMapper;
import com.lyj.e3manager.entity.TbItemDesc;
import com.lyj.e3manager.service.ItemService;
import com.lyj.e3manager.entity.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品管理Service
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemDao tbItemDao;
    @Autowired
    private TbItemDescMapper itemDescMapper;

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

    @Override
    public E3Result addItem(TbItem item,String desc){
        //生成商品id
        long itemId = IDUtils.genItemId();
        //补全item的属性
        item.setId(itemId);
        //1-正常，2-下架，3-删除
        item.setStatus("1");
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //向商品表插入数据
        tbItemDao.insert(item);
        //创建一个商品描述表对应的pojo对象。
        TbItemDesc itemDesc = new TbItemDesc();
        //补全属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        //向商品描述表插入数据
        itemDescMapper.insert(itemDesc);
        //返回成功
        return E3Result.ok();
    }
}
