package com.lyj.e3manager.dao;

import com.lyj.e3manager.entity.TbItem;

public interface TbItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);
}