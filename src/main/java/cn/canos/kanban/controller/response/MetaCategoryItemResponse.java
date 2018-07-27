package cn.canos.kanban.controller.response;

import cn.canos.kanban.vo.MetaCategoryVo;

/**
 * @author canos
 */
public class MetaCategoryItemResponse extends BaseResponse {

    private MetaCategoryVo item;

    public MetaCategoryVo getItem() {
        return item;
    }

    public void setItem(MetaCategoryVo item) {
        this.item = item;
    }
}
