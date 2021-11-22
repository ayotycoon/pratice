import java.util.*;
import java.util.stream.Collectors;

public class ListTest {


    public static void main (String[] args){
Integer[] arr = {2,5,5,6,7,8,9,0,5,6,44,5,3,4,3,54,35,345,345,435,435};

int k = 10;
  List<Integer> scores = List.of(arr);


  scores.sort((a,b) -> a-b);

  scores = scores.stream().sorted((a,b)-> b-a).collect(Collectors.toList());
        System.out.println(scores);

  int level = 1;
  int answer = 1;
  for(int i =1; i < scores.size(); i++){

      int val = scores.get(i);
      if(val == scores.get(i-1)){
          answer++;
      }else{
          if(i+1 > k){
             System.out.println("answer " +answer);
              break;
          }
          level = i+1;
          answer = level;
      }

  }
        System.out.println("answer " +answer);
    }
}
/*

       4
      / \
     2   8
        / \
       5  10
 */
