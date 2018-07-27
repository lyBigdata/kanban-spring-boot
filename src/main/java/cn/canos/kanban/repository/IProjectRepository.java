package cn.canos.kanban.repository;

import cn.canos.kanban.repository.entity.ProjectEntity;

import java.util.List;

/**
 * @author canos
 */
public interface IProjectRepository {

    /**
     * 获取所有实体
     *
     * @return 实体列表
     */
    List<ProjectEntity> getEntityList();

    /**
     * 获取单个实体
     *
     * @param id 实体编号
     * @return 实体
     */
    ProjectEntity getById(long id);

    /**
     * 分页获取实体
     *
     * @param pageIndex 页码，从1开始
     * @param pageSize 每页个数
     * @return 实体列表
     */
    List<ProjectEntity> getEntityList(int pageIndex, int pageSize);

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
    void create(ProjectEntity entity);

    /**
     * 更新实体
     *
     * @param entity 要更新的实体
     */
    void update(ProjectEntity entity);

    /**
     * 【筛选】根据 entity 获取实体列表
     *
     * @param entity
     * @return
     */
    List<ProjectEntity> getEntityListBySample(ProjectEntity entity);

    /**
     * 【筛选】根据 entity 获取实体列表
     *
     * @param entity
     * @param pageIndex 页码，从1开始
     * @param pageSize  每页个数
     * @return
     */
    List<ProjectEntity> getEntityListBySample(ProjectEntity entity, int pageIndex, int pageSize);

    /**
     * 【筛选】根据 entity 获取实体总个数
     *
     * @param entity
     * @return 实体总个数
     */
    int getCountBySample(ProjectEntity entity);
}
