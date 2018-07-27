package cn.canos.kanban.controller.response;

import cn.canos.kanban.vo.FilterGroupVo;

import java.util.List;

/**
 * @author canos
 */
public class MetaGroupFiltersResponse extends BaseResponse {

    private List<FilterGroupVo> filterGroups;

    public List<FilterGroupVo> getFilterGroups() {
        return filterGroups;
    }

    public void setFilterGroups(List<FilterGroupVo> filterGroups) {
        this.filterGroups = filterGroups;
    }
}