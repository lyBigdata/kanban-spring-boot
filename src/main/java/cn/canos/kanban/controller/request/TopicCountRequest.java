package cn.canos.kanban.controller.request;

import java.util.List;

/**
 * @author canos
 */
public class TopicCountRequest {

    private List<Integer> theGroupIdList;

    private Integer theCategoryId;

    public List<Integer> getTheGroupIdList() {
        return theGroupIdList;
    }

    public void setTheGroupIdList(List<Integer> theGroupIdList) {
        this.theGroupIdList = theGroupIdList;
    }

    public Integer getTheCategoryId() {
        return theCategoryId;
    }

    public void setTheCategoryId(Integer theCategoryId) {
        this.theCategoryId = theCategoryId;
    }

}
