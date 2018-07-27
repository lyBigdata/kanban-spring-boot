package cn.canos.kanban.repository.criteria;

import java.util.List;

/**
 * @author canos
 */
public class TopicCriteria {

    private List<Integer> groupIdList;

    private Integer categoryId;

    public List<Integer> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<Integer> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
