package cn.canos.kanban.repository.entity;

import java.io.Serializable;

/**
 * @author canos
 */
public class ProjectEntity implements Serializable {

    private Long id;

    private Integer projectId;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
