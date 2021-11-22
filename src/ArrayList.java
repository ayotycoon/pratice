import java.util.*;
import java.util.stream.Collectors;

public class ArrayList<I extends Number> {


    public static void main (String[] args){
Integer[] arr = {2,5,5,6,7,8,9,0,5,6,44,5,3,4,3,54,35,345,345,435,435};


  List<Integer> scores = new java.util.ArrayList<>(List.of(arr));


  scores.sort(Comparator.comparingInt(a -> a));

        System.out.println(scores.toString());
    }
}
/*

       4
      / \
     2   8
        / \
       5  10
 */
