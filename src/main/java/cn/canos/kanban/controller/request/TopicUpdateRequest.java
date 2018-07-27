package cn.canos.kanban.controller.request;

import cn.canos.kanban.vo.TopicVo;

/**
 * @author canos
 */
public class TopicUpdateRequest {

    private TopicVo item;

    public TopicVo getItem() {
        return item;
    }

    public void setItem(TopicVo item) {
        this.item = item;
    }
}
