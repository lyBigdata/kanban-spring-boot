package cn.canos.kanban.controller.response;

import cn.canos.kanban.vo.MetaCategoryVo;

import java.util.List;

/**
 * @author canos
 */
public class MetaCategoryItemsResponse extends BaseResponse {

    private List<MetaCategoryVo> items;

    public List<MetaCategoryVo> getItems() {
        return items;
    }

    public void setItems(List<MetaCategoryVo> items) {
        this.items = items;
    }
}
