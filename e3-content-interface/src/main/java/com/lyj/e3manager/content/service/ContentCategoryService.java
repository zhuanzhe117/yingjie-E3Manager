package com.lyj.e3manager.content.service;

import com.lyj.e3common.pojo.EasyUITreeNode;
import com.lyj.e3common.utils.E3Result;

import java.util.List;

public interface ContentCategoryService {
    List<EasyUITreeNode> getContentCatList(int parentId);

    E3Result addContentCategory(int parentId,String name);

}
