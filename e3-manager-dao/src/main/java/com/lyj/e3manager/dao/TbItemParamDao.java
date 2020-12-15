package com.lyj.e3manager.dao;

import com.lyj.e3manager.entity.TbItemParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbItemParam)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-07 16:52:41
 */
public interface TbItemParamDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbItemParam queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbItemParam> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbItemParam 实例对象
     * @return 对象列表
     */
    List<TbItemParam> queryAll(TbItemParam tbItemParam);

    /**
     * 新增数据
     *
     * @param tbItemParam 实例对象
     * @return 影响行数
     */
    int insert(TbItemParam tbItemParam);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbItemParam> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbItemParam> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbItemParam> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbItemParam> entities);

    /**
     * 修改数据
     *
     * @param tbItemParam 实例对象
     * @return 影响行数
     */
    int update(TbItemParam tbItemParam);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}