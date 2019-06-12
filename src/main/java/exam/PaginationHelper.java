package exam;

import java.util.List;


public class PaginationHelper<I> {
    private List<I> collection;
    private int itemPerPage;
    private int itemNum;
    private int pagesNum;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemPerPage = itemsPerPage;
        this.itemNum = collection.size();
        this.pagesNum = (int) Math.ceil((float) collection.size() / (float) itemPerPage);
    }


    public int itemCount() {
        return itemNum;

    }


    public int pageCount() {
        return pagesNum;
    }


    public int pageItemCount(int pageIndex) {
        if (pageIndex >= pagesNum || pageIndex < 0) return -1;
        else if ((pageIndex + 1) * itemPerPage <= itemNum) return itemPerPage;
        else return itemNum % ((pageIndex) * itemPerPage);

    }


    public int pageIndex(int itemIndex) {
        if (itemIndex >= itemNum || itemIndex < 0) return -1;
        else return itemIndex / itemPerPage;
    }
}