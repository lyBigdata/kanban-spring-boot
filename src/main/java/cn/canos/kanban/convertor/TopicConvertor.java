package cn.canos.kanban.convertor;

import cn.canos.kanban.meta.*;
import cn.canos.kanban.repository.entity.*;
import cn.canos.kanban.utility.StringJoiner;
import cn.canos.kanban.utility.StringSpliter;
import cn.canos.kanban.vo.*;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author canos
 */
@Component
public class TopicConvertor implements ITopicConvertor {

    @Autowired
    IMetaCategoryMeta metaCategoryMeta;

    @Autowired
    IMetaGroupMeta metaGroupMeta;

    @Autowired
    IMetaCategoryConvertor metaCategoryConvertor;

    @Autowired
    IMetaGroupConvertor metaGroupConvertor;

    @Override
    public TopicEntity toEntity(TopicVo vo) {

        TopicEntity entity = new TopicEntity();

        entity.setId(vo.getId());
        entity.setTitle(vo.getTitle());
        entity.setGroupId(getGroupId(vo));
        entity.setCategoryId(getCategoryId(vo));

        return entity;
    }

    @Override
    public TopicVo toVo(TopicEntity entity, boolean isEditable) {

        TopicVo vo = new TopicVo();

        List<MetaCategoryEntity> metaCategoryEntityList = metaCategoryMeta.getEntityList();

        List<MetaGroupEntity> metaGroupEntityList = metaGroupMeta.getEntityList();

        vo.setId(entity.getId());
        vo.setTitle(entity.getTitle());
        vo.setGroupId(getGroupId(metaGroupEntityList, entity, isEditable));
        vo.setCategoryId(getCategoryId(metaCategoryEntityList, entity, isEditable));

        return vo;
    }

    @Override
    public List<TopicEntity> toEntityList(List<TopicVo> voList) {

        if (voList == null || voList.isEmpty()) {
            return null;
        }

        List<TopicEntity> entityList = Lists.newArrayListWithCapacity(voList.size());
        for (TopicVo vo : voList) {
            entityList.add(toEntity(vo));
        }

        return entityList;
    }

    @Override
    public List<TopicVo> toVoList(List<TopicEntity> entityList) {

        if (entityList == null || entityList.isEmpty()) {
            return null;
        }

        List<TopicVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (TopicEntity entity : entityList) {
            voList.add(toVo(entity, false));
        }

        return voList;
    }

    private Integer getGroupId(TopicVo vo) {
        List<MetaGroupVo> items = vo.getGroupId();
        if (items == null || items.isEmpty()) {
            return 0;
        }

        for (MetaGroupVo item : items) {
            if (item.isSelected()) {
                return item.getGroupId();
            }
        }

        return 0;
    }

    private Integer getCategoryId(TopicVo vo) {
        List<MetaCategoryVo> items = vo.getCategoryId();
        if (items == null || items.isEmpty()) {
            return 0;
        }

        for (MetaCategoryVo item : items) {
            if (item.isSelected()) {
                return item.getCategoryId();
            }
        }

        return 0;
    }

    private List<MetaGroupVo> getGroupId(List<MetaGroupEntity> metaGroupEntityList, TopicEntity entity, boolean isEditable) {

        if (isEditable) {
            return metaGroupConvertor.getEditableListByIntKeyList(metaGroupEntityList, Lists.newArrayList(entity.getGroupId()));
        } else {
            return metaGroupConvertor.getVoListByIntKeyList(metaGroupEntityList, Lists.newArrayList(entity.getGroupId()));
        }
    }

    private List<MetaCategoryVo> getCategoryId(List<MetaCategoryEntity> metaCategoryEntityList, TopicEntity entity, boolean isEditable) {

        if (isEditable) {
            return metaCategoryConvertor.getEditableListByIntKeyList(metaCategoryEntityList, Lists.newArrayList(entity.getCategoryId()));
        } else {
            return metaCategoryConvertor.getVoListByIntKeyList(metaCategoryEntityList, Lists.newArrayList(entity.getCategoryId()));
        }
    }
}
