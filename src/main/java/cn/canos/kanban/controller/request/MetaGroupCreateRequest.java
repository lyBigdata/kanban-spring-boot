package cn.canos.kanban.controller.request;

import cn.canos.kanban.vo.MetaGroupVo;

/**
 * @author canos
 */
public class MetaGroupCreateRequest {

    private MetaGroupVo item;

    public MetaGroupVo getItem() {
        return item;
    }

    public void setItem(MetaGroupVo item) {
        this.item = item;
    }
}
