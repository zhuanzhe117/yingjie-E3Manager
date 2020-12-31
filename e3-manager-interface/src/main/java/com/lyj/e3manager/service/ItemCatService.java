package com.lyj.e3manager.service;

import com.lyj.e3common.pojo.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {
    List<EasyUITreeNode> getItemCatlist(long parentId);
}
