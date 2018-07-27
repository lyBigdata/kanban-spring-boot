package cn.canos.kanban.controller.response;

import cn.canos.kanban.vo.TopicVo;

import java.util.List;

/**
 * @author canos
 */
public class TopicItemsResponse extends BaseResponse {

    private List<TopicVo> items;

    public List<TopicVo> getItems() {
        return items;
    }

    public void setItems(List<TopicVo> items) {
        this.items = items;
    }
}
