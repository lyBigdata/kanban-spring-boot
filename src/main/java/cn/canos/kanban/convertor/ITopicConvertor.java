package cn.canos.kanban.convertor;

import cn.canos.kanban.repository.entity.TopicEntity;
import cn.canos.kanban.vo.TopicVo;

import java.util.List;

/**
 * @author canos
 */
public interface ITopicConvertor {

    /**
     * vo 转换为 entity
     * @param vo 需要转换的 vo
     * @return 转换之后的 entity
     */
    TopicEntity toEntity(TopicVo vo);

    /**
     * entity 转换为 vo
     * @param entity 需要转换的 entity
     * @param isEditable 使用用于编辑
     * @return 转换之后的 vo
     */
    TopicVo toVo(TopicEntity entity, boolean isEditable);

    /**
     * voList 转换为 entityList
     * @param voList 需要转换的 voList
     * @return 转换之后的 entityList
     */
    List<TopicEntity> toEntityList(List<TopicVo> voList);

    /**
     * entityList 转换为 voList
     * @param entityList 需要转换的 entityList
     * @return 转换之后的 voList
     */
    List<TopicVo> toVoList(List<TopicEntity> entityList);
}
