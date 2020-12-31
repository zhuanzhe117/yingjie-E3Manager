package com.lyj.e3manager.service.impl;

import com.lyj.e3common.pojo.EasyUITreeNode;
import com.lyj.e3manager.dao.TbItemCatMapper;
import com.lyj.e3manager.entity.TbItem;
import com.lyj.e3manager.entity.TbItemCat;
import com.lyj.e3manager.entity.TbItemCatExample;
import com.lyj.e3manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lyj.e3manager.entity.TbItemCatExample.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public List<EasyUITreeNode> getItemCatlist(long parentId) {

        //执行查询
        TbItemCat tbItemCat = new TbItemCat();
        tbItemCat.setParentId(parentId);
        //执行查询
        List<TbItemCat> list = itemCatMapper.queryAll(tbItemCat);
        //创建返回结果List
        List<EasyUITreeNode> resultList = new ArrayList<>();
        //把列表转换成EasyUITreeNode列表
        for (TbItemCat i : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            //设置属性
            node.setId(i.getId());
            node.setText(i.getName());
            node.setState(i.getIsParent() ? "closed" : "open");
            //添加到结果列表
            resultList.add(node);
        }
        return resultList;
    }
}
