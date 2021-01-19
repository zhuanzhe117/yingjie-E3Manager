package com.lyj.e3manager.content.service;

import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.entity.TbContent;

import java.util.List;

public interface ContentService {
    E3Result addContent(TbContent content);
    List<TbContent> getContentListByCid(long cid);
}
