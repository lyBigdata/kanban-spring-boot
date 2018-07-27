package cn.canos.kanban.repository.mock;

class PageParam {

    private boolean inValid;
    private int entityListSize;
    private int pageIndex;
    private int pageSize;
    private int fromIndex;
    private int toIndex;

    public PageParam(int entityListSize, int pageIndex, int pageSize) {
        this.entityListSize = entityListSize;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    boolean isInvalid() {
        return inValid;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    public int getToIndex() {
        return toIndex;
    }

    public PageParam invoke() {
        fromIndex = (pageIndex - 1) * pageSize;
        toIndex = pageIndex * pageSize;
        if (fromIndex >= entityListSize) {
            inValid = true;
            return this;
        }
        if (toIndex >= entityListSize) {
            toIndex = entityListSize;
        }
        inValid = false;
        return this;
    }
}
