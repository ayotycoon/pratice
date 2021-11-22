//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//class UserDTO{
//    private String title;
//    private String url;
//    private String author;
//    private Integer num_comments ;
//    private Integer story_id;
//    private String story_title;
//    private String story_url;
//    private Integer parent_id;
//    private LocalDate created_at;
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public Integer getNum_comments() {
//        return num_comments;
//    }
//
//    public void setNum_comments(Integer num_comments) {
//        this.num_comments = num_comments;
//    }
//
//    public Integer getStory_id() {
//        return story_id;
//    }
//
//    public void setStory_id(Integer story_id) {
//        this.story_id = story_id;
//    }
//
//    public String getStory_title() {
//        return story_title;
//    }
//
//    public void setStory_title(String story_title) {
//        this.story_title = story_title;
//    }
//
//    public String getStory_url() {
//        return story_url;
//    }
//
//    public void setStory_url(String story_url) {
//        this.story_url = story_url;
//    }
//
//    public Integer getParent_id() {
//        return parent_id;
//    }
//
//    public void setParent_id(Integer parent_id) {
//        this.parent_id = parent_id;
//    }
//
//    public LocalDate getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(LocalDate created_at) {
//        this.created_at = created_at;
//    }
//    public boolean isValid(){
//        return !(this.title == null && this.story_title == null);
//    }
//
//    public String getName(){
//        return this.title == null ? this.story_title : title;
//    }
//
//}
//
//class ResponseDTO{
//    private Integer page ;
//    private Integer per_page ;
//    private Integer total ;
//    private Integer total_pages ;
//    private List<UserDTO> data;
//
//    public Integer getPage() {
//        return page;
//    }
//
//    public void setPage(Integer page) {
//        this.page = page;
//    }
//
//    public Integer getPer_page() {
//        return per_page;
//    }
//
//    public void setPer_page(Integer per_page) {
//        this.per_page = per_page;
//    }
//
//    public Integer getTotal() {
//        return total;
//    }
//
//    public void setTotal(Integer total) {
//        this.total = total;
//    }
//
//    public Integer getTotal_pages() {
//        return total_pages;
//    }
//
//    public void setTotal_pages(Integer total_pages) {
//        this.total_pages = total_pages;
//    }
//
//    public List<UserDTO> getData() {
//        return data;
//    }
//
//    public void setData(List<UserDTO> data) {
//        this.data = data;
//    }
//
//
//}
//
//public class Result {
//
//    /*
//     * Complete the 'topArticles' function below.
//     *
//     * The function is expected to return a STRING_ARRAY.
//     * The function accepts following parameters:
//     *  1. STRING username
//     *  2. INTEGER limit
//     *
//     * base url for copy/paste
//     *
//     */
//private static ResponseDTO makeRequest(String username, int pageNumber) throws IOException {
//
//
//    URL url = new URL("https://jsonmock.hackerrank.com/api/articles?author="+ username+"&page="+ pageNumber);
//
//
//
//
//
//}
//    public static List<String> topArticles(String username, int limit) throws IOException {
//
//ResponseDTO response = makeRequest(username,1);
//
//List<UserDTO> data = response.getData();
//
//
//List<String> sorted =  data.stream().sorted((UserDTO a, UserDTO b )-> {
//    int noOfComments = b.getNum_comments() - a.getNum_comments();
//
//
//    if(noOfComments != 0) return noOfComments;
//
//    int strDiff = isStringGreater(a.getName() , b.getName());
//    return strDiff;
//
//}).map((UserDTO a) -> a.getAuthor()).collect(Collectors.toList());
//
//
//        List<String> ans = new ArrayList<>(sorted.size());
//        int i = 1;
//        for(String s: sorted){
//            ans.add(s);
//
//            i++;
//            if(i >= limit) break;
//        }
//        return ans;
//    }
//
//    private static int isStringGreater(String s1, String s2){
//    if(s1 == null) return -1;
//    if(s2 == null) return 1;
//
//    char [] _s1 = s1.toCharArray();
//    char [] _s2 = s2.toCharArray();
//
//
//        for (int i = 0; i < _s1.length; i++) {
//            char s1Char = _s1[i];
//
//            if(i >= _s2.length){
//                return 1;
//            }
//            char s2Char = _s2[i];
//
//            if(s1Char > s2Char) return 1;
//            if(s1Char < s2Char) return -1;
//
//        }
//
//    }
//}
