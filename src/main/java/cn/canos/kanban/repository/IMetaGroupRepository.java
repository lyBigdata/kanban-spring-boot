package cn.canos.kanban.repository;

import cn.canos.kanban.repository.entity.MetaGroupEntity;

import java.util.List;

/**
 * @author canos
 */
public interface IMetaGroupRepository {

    /**
     * 获取所有实体
     *
     * @return 实体列表
     */
    List<MetaGroupEntity> getEntityList();

    /**
     * 获取单个实体
     *
     * @param id 实体编号
     * @return 实体
     */
    MetaGroupEntity getById(long id);

    /**
     * 分页获取实体
     *
     * @param pageIndex 页码，从1开始
     * @param pageSize 每页个数
     * @return 实体列表
     */
    List<MetaGroupEntity> getEntityList(int pageIndex, int pageSize);

    /**
     * 获取实体总个数
     *
     * @return 实体总个数
     */
    int getCount();

    /**
     * 新增实体
     *
     * @param entity 要新增的实体
     */
    void create(MetaGroupEntity entity);

    /**
     * 更新实体
     *
     * @param entity 要更新的实体
     */
    void update(MetaGroupEntity entity);

    /**
     * 【筛选】根据 entity 获取实体列表
     *
     * @param entity
     * @return
     */
    List<MetaGroupEntity> getEntityListBySample(MetaGroupEntity entity);

    /**
     * 【筛选】根据 entity 获取实体列表
     *
     * @param entity
     * @param pageIndex 页码，从1开始
     * @param pageSize  每页个数
     * @return
     */
    List<MetaGroupEntity> getEntityListBySample(MetaGroupEntity entity, int pageIndex, int pageSize);

    /**
     * 【筛选】根据 entity 获取实体总个数
     *
     * @param entity
     * @return 实体总个数
     */
    int getCountBySample(MetaGroupEntity entity);
}
