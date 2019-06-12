package exam;

import java.util.List;


public class PaginationHelper<I> {
    private List<I> collection ;
    private int itemPerPage ;
    //item num in total
    private int itemNum ;
    //page num in total
    private int pagesNum;


    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemPerPage = itemsPerPage;
        this.itemNum = collection.size();
        // low performance calculate pagesNum;
        this.pagesNum = (int) Math.ceil((float) collection.size() / (float) itemPerPage);
    }


    public int itemCount() { return itemNum; }


    public int pageCount() {
        return pagesNum;
    }

    /**
     * pageIndex(zero based index)
     * @param pageIndex
     * @return itemsInPage
     */
    public int pageItemCount(int pageIndex) {
        //legal check
        if (pageIndex >= pagesNum || pageIndex < 0) return -1;
        //full item page
        else if ((pageIndex + 1) * itemPerPage <= itemNum) return itemPerPage;
        //last page
        else return itemNum % ((pageIndex) * itemPerPage);

    }

    /**
     * itemIndex (zero based index)
     * @param itemIndex
     * @return iteminPage
     */
    public int pageIndex(int itemIndex) {
        //legal check
        if (itemIndex >= itemNum || itemIndex < 0) return -1;
        //perform
        else return itemIndex / itemPerPage;
    }
}