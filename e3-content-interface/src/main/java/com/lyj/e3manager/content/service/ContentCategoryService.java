package com.lyj.e3manager.content.service;

import com.lyj.e3common.pojo.EasyUITreeNode;

import java.util.List;

public interface ContentCategoryService {
    List<EasyUITreeNode> getContentCatList(int parentId);
}
