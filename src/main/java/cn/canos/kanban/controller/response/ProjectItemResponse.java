package cn.canos.kanban.controller.response;

import cn.canos.kanban.vo.ProjectVo;

/**
 * @author canos
 */
public class ProjectItemResponse extends BaseResponse {

    private ProjectVo item;

    public ProjectVo getItem() {
        return item;
    }

    public void setItem(ProjectVo item) {
        this.item = item;
    }
}
