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
public class MetaCategoryConvertor implements IMetaCategoryConvertor {

    @Override
    public MetaCategoryEntity toEntity(MetaCategoryVo vo) {

        MetaCategoryEntity entity = new MetaCategoryEntity();

        entity.setId(vo.getId());
        entity.setCategoryId(vo.getCategoryId());
        entity.setCategoryName(vo.getCategoryName());

        return entity;
    }

    @Override
    public MetaCategoryVo toVo(MetaCategoryEntity entity, boolean isEditable) {

        MetaCategoryVo vo = new MetaCategoryVo();

        vo.setId(entity.getId());
        vo.setCategoryId(entity.getCategoryId());
        vo.setCategoryName(entity.getCategoryName());

        return vo;
    }

    @Override
    public List<MetaCategoryEntity> toEntityList(List<MetaCategoryVo> voList) {

        if (voList == null || voList.isEmpty()) {
            return null;
        }

        List<MetaCategoryEntity> entityList = Lists.newArrayListWithCapacity(voList.size());
        for (MetaCategoryVo vo : voList) {
            entityList.add(toEntity(vo));
        }

        return entityList;
    }

    @Override
    public List<MetaCategoryVo> toVoList(List<MetaCategoryEntity> entityList) {

        if (entityList == null || entityList.isEmpty()) {
            return null;
        }

        List<MetaCategoryVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (MetaCategoryEntity entity : entityList) {
            voList.add(toVo(entity, false));
        }

        return voList;
    }

    @Override
    public List<MetaCategoryVo> getVoListByIntKeyList(List<MetaCategoryEntity> entityList, List<Integer> keys) {

        List<MetaCategoryVo> voList = Lists.newArrayListWithCapacity(keys.size());
        for (Integer value : keys) {

            MetaCategoryVo vo = getVoByIntKey(entityList, value);
            if (vo != null) {
                voList.add(vo);
            }
        }

        return voList;
    }

    @Override
    public List<MetaCategoryVo> getEditableListByIntKeyList(List<MetaCategoryEntity> entityList, List<Integer> keys) {

        List<MetaCategoryVo> voList = Lists.newArrayListWithCapacity(entityList.size());
        for (MetaCategoryEntity entity : entityList) {

            MetaCategoryVo vo = toVo(entity, true);
            if (keys.contains(entity.getCategoryId())) {
                vo.setSelected(true);
            }
            voList.add(vo);
        }

        return voList;
    }

    @Override
    public MetaCategoryVo getVoByIntKey(List<MetaCategoryEntity> entityList, Integer key) {

        for (MetaCategoryEntity entity : entityList) {

            if (!entity.getCategoryId().equals(key)) {
                continue;
            }

            MetaCategoryVo vo = toVo(entity, false);

            return vo;
        }

        return null;
    }
}
