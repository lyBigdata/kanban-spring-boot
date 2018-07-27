package cn.canos.kanban.filter;

import cn.canos.kanban.meta.IMetaCategoryMeta;
import cn.canos.kanban.repository.entity.MetaCategoryEntity;
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
public class TopicTheCategoryIdFilterGroupProvider implements ITopicTheCategoryIdFilterGroupProvider {

    @Autowired
    IMetaCategoryMeta metaCategoryMeta;

    @Override
    public FilterGroupVo getFilterGroup() {

        List<MetaCategoryEntity> entityList = metaCategoryMeta.getEntityList();
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }

        FilterGroupVo filterGroup = new FilterGroupVo();
        filterGroup.setGroupKey("theCategoryId");
        filterGroup.setGroupText("分类");
        filterGroup.setMultiSelect(false);

        List<FilterVo> filterVos = Lists.newArrayList();
        for (MetaCategoryEntity entity : entityList) {

            FilterVo filterVo = new FilterVo();
            filterVo.setFilterKey(String.valueOf(entity.getCategoryId()));
            filterVo.setFilterText(entity.getCategoryName());
            filterVos.add(filterVo);
        }
        filterGroup.setFilters(filterVos);

        return filterGroup;
    }
}
