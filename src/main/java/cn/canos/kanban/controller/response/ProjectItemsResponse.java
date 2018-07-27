package cn.canos.kanban.controller.response;

import cn.canos.kanban.vo.ProjectVo;

import java.util.List;

/**
 * @author canos
 */
public class ProjectItemsResponse extends BaseResponse {

    private List<ProjectVo> items;

    public List<ProjectVo> getItems() {
        return items;
    }

    public void setItems(List<ProjectVo> items) {
        this.items = items;
    }
}
