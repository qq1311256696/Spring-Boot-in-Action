package hys.mongodb.beans;

public class Pager {

    public static final Integer SIZE = 15;
    /**
     *
     */
    private Integer pageNumber;
    /**
     *
     */
    private Integer pageSize = SIZE;

    /**
     * 倒序
     */
    private int sort = -1;

    @Override
    public String toString() {
        return "Pager{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize == 0) {
            pageSize = SIZE;
        }
        this.pageSize = pageSize;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
