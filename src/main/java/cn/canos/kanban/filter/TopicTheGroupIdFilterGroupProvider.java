package cn.canos.kanban.filter;

import cn.canos.kanban.meta.IMetaGroupMeta;
import cn.canos.kanban.repository.entity.MetaGroupEntity;
import cn.canos.kanban.vo.FilterGroupVo;
import cn.canos.kanban.vo.FilterVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author canos
 */
@Component
public class TopicTheGroupIdFilterGroupProvider implements ITopicTheGroupIdFilterGroupProvider {

    @Autowired
    IMetaGroupMeta metaGroupMeta;

    @Override
    public FilterGroupVo getFilterGroup() {

        List<MetaGroupEntity> entityList = metaGroupMeta.getEntityList();
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }

        FilterGroupVo filterGroup = new FilterGroupVo();
        filterGroup.setGroupKey("theGroupId");
        filterGroup.setGroupText("分组");
        filterGroup.setMultiSelect(true);

        List<FilterVo> filterVos = Lists.newArrayList();
        for (MetaGroupEntity entity : entityList) {

            FilterVo filterVo = new FilterVo();
            filterVo.setFilterKey(String.valueOf(entity.getGroupId()));
            filterVo.setFilterText(entity.getGroupName());
            filterVos.add(filterVo);
        }
        filterGroup.setFilters(filterVos);

        return filterGroup;
    }
}
