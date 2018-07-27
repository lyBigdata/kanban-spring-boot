package cn.canos.kanban.vo;

import java.util.List;

/**
 * @author canos
 */
public class TopicVo {

    private Long id;

    private String title;

    private List<MetaGroupVo> groupId;

    private List<MetaCategoryVo> categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MetaGroupVo> getGroupId() {
        return groupId;
    }

    public void setGroupId(List<MetaGroupVo> groupId) {
        this.groupId = groupId;
    }

    public List<MetaCategoryVo> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(List<MetaCategoryVo> categoryId) {
        this.categoryId = categoryId;
    }
}
