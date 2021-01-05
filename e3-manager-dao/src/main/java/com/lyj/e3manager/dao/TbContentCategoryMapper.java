package com.lyj.e3manager.dao;

import com.lyj.e3manager.entity.TbContentCategory;
import com.lyj.e3manager.entity.TbContentCategoryExample;
import java.util.List;

public interface TbContentCategoryMapper {


    List<TbContentCategory> selectByExample(TbContentCategory tbContentCategory);


}