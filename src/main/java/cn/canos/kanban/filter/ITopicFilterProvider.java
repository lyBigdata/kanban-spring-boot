package cn.canos.kanban.filter;

import cn.canos.kanban.vo.FilterGroupVo;

import java.util.List;

/**
 * @author canos
 */
public interface ITopicFilterProvider {

    List<FilterGroupVo> getFilters();
}
