package cn.canos.kanban.convertor;

import cn.canos.kanban.repository.entity.*;
import cn.canos.kanban.utility.StringJoiner;
import cn.canos.kanban.utility.StringSpliter;
import cn.canos.kanban.vo.*;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author canos
 */
@Component
public class MetaGroupConvertor implements IMetaGroupConvertor {

    @Override
    public MetaGroupEntity toEntity(MetaGroupVo vo) {

        MetaGroupEntity entity = new MetaGroupEntity();

        entity.setId(vo.getId());
        entity.setGroupId(vo.getGroupId());
        entity.setGroupName(vo.getGroupName());

        return entity;
    }

    @Override
    public MetaGroupVo toVo(MetaGroupEntity entity, boolean isEditable) {

        MetaGroupVo vo = new MetaGroupVo();

        vo.setId(entity.getId());
        vo.setGroupId(entity.getGroupId());
        vo.setGroupName(entity.getGroupName());

        return vo;
    }

    @Override
    public List<MetaGroupEntity> toEntityList(List<MetaGroupVo> voList) {

        if (voList == null || voList.isEmpty()) {
            return null;
        }

        List<MetaGroupEntity> entityList = Lists.newArrayListWithCapacity(voList.size());
        for (MetaGroupVo vo : voList) {
            entityList.add(toEntity(vo));
        }

        return entityList;
    }

    @Override
    public List<MetaGroupVo> toVoList(List<MetaGroupEntity> entityList) {

        if (entityList == null || entityList.isEmpty()) {
            return null;
        }

        List<MetaGroupVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (MetaGroupEntity entity : entityList) {
            voList.add(toVo(entity, false));
        }

        return voList;
    }

    @Override
    public List<MetaGroupVo> getVoListByIntKeyList(List<MetaGroupEntity> entityList, List<Integer> keys) {

        List<MetaGroupVo> voList = Lists.newArrayListWithCapacity(keys.size());
        for (Integer value : keys) {

            MetaGroupVo vo = getVoByIntKey(entityList, value);
            if (vo != null) {
                voList.add(vo);
            }
        }

        return voList;
    }

    @Override
    public List<MetaGroupVo> getEditableListByIntKeyList(List<MetaGroupEntity> entityList, List<Integer> keys) {

        List<MetaGroupVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (MetaGroupEntity entity : entityList) {

            MetaGroupVo vo = toVo(entity, true);
            if (keys.contains(entity.getGroupId())) {
                vo.setSelected(true);
            }
            voList.add(vo);
        }

        return voList;
    }

    @Override
    public MetaGroupVo getVoByIntKey(List<MetaGroupEntity> entityList, Integer key) {

        for (MetaGroupEntity entity : entityList) {

            if (!entity.getGroupId().equals(key)) {
                continue;
            }

            MetaGroupVo vo = toVo(entity, false);

            return vo;
        }

        return null;
    }
}
