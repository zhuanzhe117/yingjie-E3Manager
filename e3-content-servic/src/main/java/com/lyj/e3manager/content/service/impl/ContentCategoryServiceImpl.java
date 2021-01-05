package com.lyj.e3manager.content.service.impl;

import com.lyj.e3common.pojo.EasyUITreeNode;
import com.lyj.e3manager.content.service.ContentCategoryService;
import com.lyj.e3manager.dao.TbContentCategoryMapper;
import com.lyj.e3manager.entity.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<EasyUITreeNode> getContentCatList(int parentId){
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentId);
        List<TbContentCategory> catList = contentCategoryMapper.queryAll(tbContentCategory);
        List<EasyUITreeNode> nodeList = new ArrayList<>();
        for(TbContentCategory i : catList){
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(i.getId());
            node.setText(i.getName());
            node.setState(i.getIsParent()?"closed":"open");
            nodeList.add(node);
        }
        return nodeList;
    }

}
