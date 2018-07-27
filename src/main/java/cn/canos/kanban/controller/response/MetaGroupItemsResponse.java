package cn.canos.kanban.controller.response;

import cn.canos.kanban.vo.MetaGroupVo;

import java.util.List;

/**
 * @author canos
 */
public class MetaGroupItemsResponse extends BaseResponse {

    private List<MetaGroupVo> items;

    public List<MetaGroupVo> getItems() {
        return items;
    }

    public void setItems(List<MetaGroupVo> items) {
        this.items = items;
    }
}
