package cn.canos.kanban.convertor;

import cn.canos.kanban.repository.entity.MetaGroupEntity;
import cn.canos.kanban.vo.MetaGroupVo;

import java.util.List;

/**
 * @author canos
 */
public interface IMetaGroupConvertor {

    /**
     * vo 转换为 entity
     * @param vo 需要转换的 vo
     * @return 转换之后的 entity
     */
    MetaGroupEntity toEntity(MetaGroupVo vo);

    /**
     * entity 转换为 vo
     * @param entity 需要转换的 entity
     * @param isEditable 使用用于编辑
     * @return 转换之后的 vo
     */
    MetaGroupVo toVo(MetaGroupEntity entity, boolean isEditable);

    /**
     * voList 转换为 entityList
     * @param voList 需要转换的 voList
     * @return 转换之后的 entityList
     */
    List<MetaGroupEntity> toEntityList(List<MetaGroupVo> voList);

    /**
     * entityList 转换为 voList
     * @param entityList 需要转换的 entityList
     * @return 转换之后的 voList
     */
    List<MetaGroupVo> toVoList(List<MetaGroupEntity> entityList);

    /**
     * 从 entityList 中获取符合条件的 entityList, 并转换为 voList。用于展示
     * @param entityList 所有的 entityList
     * @param keys 用于筛选出符合条件的 entityList
     * @return 转换之后的 voList
     */
    List<MetaGroupVo> getVoListByIntKeyList(List<MetaGroupEntity> entityList, List<Integer> keys);

    /**
     * 从 entityList 中获取符合条件的 entityList, 并转换为 voList。用于编辑
     * @param entityList 所有的 entityList
     * @param keys 用于筛选出符合条件的 entityList
     * @return 转换之后的 voList
     */
    List<MetaGroupVo> getEditableListByIntKeyList(List<MetaGroupEntity> entityList, List<Integer> keys);

    /**
     * 从 entityList 中获取符合条件的 entity, 并转换为 vo
     * @param entityList 所有的 entityList
     * @param key 用于筛选出符合条件的 entityList
     * @return 转换之后的 vo
     */
    MetaGroupVo getVoByIntKey(List<MetaGroupEntity> entityList, Integer key);
}
