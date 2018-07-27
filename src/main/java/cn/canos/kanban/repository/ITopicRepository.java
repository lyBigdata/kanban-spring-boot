package cn.canos.kanban.repository;

import cn.canos.kanban.repository.criteria.TopicCriteria;
import cn.canos.kanban.repository.entity.TopicEntity;

import java.util.List;

/**
 * @author canos
 */
public interface ITopicRepository {

    /**
     * 获取所有实体
     *
     * @return 实体列表
     */
    List<TopicEntity> getEntityList();

    /**
     * 获取单个实体
     *
     * @param id 实体编号
     * @return 实体
     */
    TopicEntity getById(long id);

    /**
     * 分页获取实体
     *
     * @param pageIndex 页码，从1开始
     * @param pageSize 每页个数
     * @return 实体列表
     */
    List<TopicEntity> getEntityList(int pageIndex, int pageSize);

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
    void create(TopicEntity entity);

    /**
     * 更新实体
     *
     * @param entity 要更新的实体
     */
    void update(TopicEntity entity);

    /**
     * 【筛选】根据 entity 获取实体列表
     *
     * @param entity
     * @return
     */
    List<TopicEntity> getEntityListBySample(TopicEntity entity);

    /**
     * 【筛选】根据 entity 获取实体列表
     *
     * @param entity
     * @param pageIndex 页码，从1开始
     * @param pageSize  每页个数
     * @return
     */
    List<TopicEntity> getEntityListBySample(TopicEntity entity, int pageIndex, int pageSize);

    /**
     * 【筛选】根据 entity 获取实体总个数
     *
     * @param entity
     * @return 实体总个数
     */
    int getCountBySample(TopicEntity entity);

    /**
     * 【筛选】根据 筛选项 获取实体列表
     *
     * @param criteria
     * @return
     */
    List<TopicEntity> getEntityListByCriteria(TopicCriteria criteria);

    /**
     * 【筛选】根据 筛选项 获取实体列表
     *
     * @param criteria
     * @param pageIndex 页码，从1开始
     * @param pageSize  每页个数
     * @return
     */
    List<TopicEntity> getEntityListByCriteria(TopicCriteria criteria, int pageIndex, int pageSize);

    /**
     * 【筛选】根据 筛选项 获取实体总个数
     *
     * @param criteria
     * @return 实体总个数
     */
    int getCountByCriteria(TopicCriteria criteria);
}
