package com.lyj.e3manager.dao;

import com.lyj.e3manager.entity.TbItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbItem)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-07 16:51:29
 */
public interface TbItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbItem queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbItem> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbItem 实例对象
     * @return 对象列表
     */
    List<TbItem> queryAll(TbItem tbItem);

    /**
     * 新增数据
     *
     * @param tbItem 实例对象
     * @return 影响行数
     */
    int insert(TbItem tbItem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbItem> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbItem> entities);

    /**
     * 修改数据
     *
     * @param tbItem 实例对象
     * @return 影响行数
     */
    int update(TbItem tbItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}