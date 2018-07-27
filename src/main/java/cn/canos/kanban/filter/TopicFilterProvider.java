package cn.canos.kanban.filter;

import cn.canos.kanban.vo.FilterGroupVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author canos
 */
@Service
public class TopicFilterProvider implements ITopicFilterProvider {

    @Autowired
    ITopicTheGroupIdFilterGroupProvider topicTheGroupIdFilterGroupProvider;

    @Autowired
    ITopicTheCategoryIdFilterGroupProvider topicTheCategoryIdFilterGroupProvider;

    @Override
    public List<FilterGroupVo> getFilters() {

        List<FilterGroupVo> filterGroups = Lists.newArrayList();

        {
            FilterGroupVo filterGroup = topicTheGroupIdFilterGroupProvider.getFilterGroup();
            if (filterGroup != null) {
                filterGroups.add(filterGroup);
            }
        }
        {
            FilterGroupVo filterGroup = topicTheCategoryIdFilterGroupProvider.getFilterGroup();
            if (filterGroup != null) {
                filterGroups.add(filterGroup);
            }
        }

        return filterGroups;
    }
}
