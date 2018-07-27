package cn.canos.kanban.controller.response;

import cn.canos.kanban.vo.MetaGroupVo;

/**
 * @author canos
 */
public class MetaGroupItemResponse extends BaseResponse {

    private MetaGroupVo item;

    public MetaGroupVo getItem() {
        return item;
    }

    public void setItem(MetaGroupVo item) {
        this.item = item;
    }
}
