package com.lyj.e3manager.dao;

import com.lyj.e3manager.entity.TbOrderShipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbOrderShipping)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-07 16:54:27
 */
public interface TbOrderShippingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    TbOrderShipping queryById();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbOrderShipping> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbOrderShipping 实例对象
     * @return 对象列表
     */
    List<TbOrderShipping> queryAll(TbOrderShipping tbOrderShipping);

    /**
     * 新增数据
     *
     * @param tbOrderShipping 实例对象
     * @return 影响行数
     */
    int insert(TbOrderShipping tbOrderShipping);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbOrderShipping> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbOrderShipping> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbOrderShipping> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbOrderShipping> entities);

    /**
     * 修改数据
     *
     * @param tbOrderShipping 实例对象
     * @return 影响行数
     */
    int update(TbOrderShipping tbOrderShipping);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 影响行数
     */
    int deleteById();

}