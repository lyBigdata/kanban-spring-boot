package cn.canos.kanban.meta;

import cn.canos.kanban.repository.entity.MetaGroupEntity;

import java.util.List;

/**
 * @author canos
 */
public interface IMetaGroupMeta {

    /**
     * 获取元数据列表
     * @return 元数据列表
     */
    List<MetaGroupEntity> getEntityList();

    /**
     * 刷新缓存
     */
    void refresh();
}
