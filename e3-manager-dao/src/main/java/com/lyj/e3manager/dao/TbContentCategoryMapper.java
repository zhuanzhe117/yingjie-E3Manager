package com.lyj.e3manager.dao;

import com.lyj.e3manager.entity.TbContentCategory;
import com.lyj.e3manager.entity.TbContentCategoryExample;
import java.util.List;

public interface TbContentCategoryMapper {


    TbContentCategory selectByPrimaryKey(int id);

    List<TbContentCategory> queryAll(TbContentCategory tbContentCategory);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);
}