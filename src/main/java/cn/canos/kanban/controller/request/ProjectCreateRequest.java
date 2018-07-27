package cn.canos.kanban.controller.request;

import cn.canos.kanban.vo.ProjectVo;

/**
 * @author canos
 */
public class ProjectCreateRequest {

    private ProjectVo item;

    public ProjectVo getItem() {
        return item;
    }

    public void setItem(ProjectVo item) {
        this.item = item;
    }
}
