package cn.canos.kanban.controller.response;

/**
 * @author canos
 */
public class TopicCountResponse extends BaseResponse {

    private long totalCount;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
