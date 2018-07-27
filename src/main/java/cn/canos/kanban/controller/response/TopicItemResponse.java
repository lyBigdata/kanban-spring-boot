package cn.canos.kanban.controller.response;

import cn.canos.kanban.vo.TopicVo;

/**
 * @author canos
 */
public class TopicItemResponse extends BaseResponse {

    private TopicVo item;

    public TopicVo getItem() {
        return item;
    }

    public void setItem(TopicVo item) {
        this.item = item;
    }
}
