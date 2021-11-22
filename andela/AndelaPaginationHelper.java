public class AndelaPaginationHelper<I> {

    private List<I> list;
    private int itemsPerPage;
    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public AndelaPaginationHelper(List<I> collection, int itemsPerPage) {
            this.list = collection;
            this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
       return this.list.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        int count = this.list.size()%itemsPerPage;
        int val = this.list.size()/itemsPerPage;
        if (count>0){
            return val+1;
        }
        else return val;
    }

     /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if(pageIndex<0||pageIndex>pageCount()) return -1;
        if (itemCount()%itemsPerPage ==0){
            return itemsPerPage;
        }
        else {
            int val = itemCount()/itemsPerPage;
            return (itemCount()-(val*itemsPerPage));
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        int pageIndex = itemIndex%itemsPerPage;
        int page = itemIndex/itemsPerPage;
        if (pageIndex==0){
            return page-1;
        }else{
            return page;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        AndelaPaginationHelper<Integer> helper = new AndelaPaginationHelper<>(arrayList,3);
        System.out.println(helper.pageCount());
        System.out.println(helper.itemCount());
        System.out.println(helper.pageIndex(3));
        System.out.println(helper.pageItemCount(4));
    }
}