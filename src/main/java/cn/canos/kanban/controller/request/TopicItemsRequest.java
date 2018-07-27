package cn.canos.kanban.controller.request;

/**
 * @author canos
 */
public class TopicItemsRequest extends TopicCountRequest {

    private int pageIndex;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
