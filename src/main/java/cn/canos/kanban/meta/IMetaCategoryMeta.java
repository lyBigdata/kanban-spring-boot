package cn.canos.kanban.meta;

import cn.canos.kanban.repository.entity.MetaCategoryEntity;

import java.util.List;

/**
 * @author canos
 */
public interface IMetaCategoryMeta {

    /**
     * 获取元数据列表
     * @return 元数据列表
     */
    List<MetaCategoryEntity> getEntityList();

    /**
     * 刷新缓存
     */
    void refresh();
}
