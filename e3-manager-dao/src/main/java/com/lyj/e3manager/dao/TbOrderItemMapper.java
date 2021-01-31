package com.lyj.e3manager.dao;




import com.lyj.e3manager.entity.TbOrderItem;

public interface TbOrderItemMapper {

    int deleteByPrimaryKey(String id);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    TbOrderItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbOrderItem record);

    int updateByPrimaryKey(TbOrderItem record);
}