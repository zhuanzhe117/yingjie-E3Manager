package com.lyj.e3manager.dao;

import com.lyj.e3manager.entity.TbUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserMapper {


    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUser example);

    TbUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}