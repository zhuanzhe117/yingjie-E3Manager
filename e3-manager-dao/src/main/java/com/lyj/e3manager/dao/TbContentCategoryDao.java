package com.lyj.e3manager.dao;

import com.lyj.e3manager.entity.TbContentCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbContentCategory)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-07 16:50:36
 */
public interface TbContentCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbContentCategory queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbContentCategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbContentCategory 实例对象
     * @return 对象列表
     */
    List<TbContentCategory> queryAll(TbContentCategory tbContentCategory);

    /**
     * 新增数据
     *
     * @param tbContentCategory 实例对象
     * @return 影响行数
     */
    int insert(TbContentCategory tbContentCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbContentCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbContentCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbContentCategory> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbContentCategory> entities);

    /**
     * 修改数据
     *
     * @param tbContentCategory 实例对象
     * @return 影响行数
     */
    int update(TbContentCategory tbContentCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}