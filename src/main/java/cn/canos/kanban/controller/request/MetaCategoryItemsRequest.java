package cn.canos.kanban.controller.request;

/**
 * @author canos
 */
public class MetaCategoryItemsRequest extends MetaCategoryCountRequest {

    private int pageIndex;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
