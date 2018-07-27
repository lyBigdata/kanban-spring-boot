package cn.canos.kanban.vo;

import java.util.List;

/**
 * @author canos
 */
public class FilterGroupVo {

    private String groupKey;

    private String groupText;

    private boolean multiSelect;

    private List<FilterVo> filters;

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getGroupText() {
        return groupText;
    }

    public void setGroupText(String groupText) {
        this.groupText = groupText;
    }

    public boolean isMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    public List<FilterVo> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterVo> filters) {
        this.filters = filters;
    }
}
