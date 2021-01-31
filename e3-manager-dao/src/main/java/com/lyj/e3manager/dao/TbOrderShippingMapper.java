package com.lyj.e3manager.dao;

import java.util.List;

import com.lyj.e3manager.entity.TbOrderShipping;
import org.apache.ibatis.annotations.Param;

public interface TbOrderShippingMapper {

    int deleteByPrimaryKey(String orderId);

    int insert(TbOrderShipping record);

    int insertSelective(TbOrderShipping record);

    TbOrderShipping selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(TbOrderShipping record);

    int updateByPrimaryKey(TbOrderShipping record);
}