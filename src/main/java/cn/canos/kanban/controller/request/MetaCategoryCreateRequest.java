package cn.canos.kanban.controller.request;

import cn.canos.kanban.vo.MetaCategoryVo;

/**
 * @author canos
 */
public class MetaCategoryCreateRequest {

    private MetaCategoryVo item;

    public MetaCategoryVo getItem() {
        return item;
    }

    public void setItem(MetaCategoryVo item) {
        this.item = item;
    }
}
