import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PermutationsOfNumber {

    private static List<List<Integer>> solve(Integer[] arr, Map<String,List<List<Integer>>> memo) {
     var x = Arrays.toString(arr);

        if(memo.containsKey(x)) {

            return memo.get(x);
        }
        if(arr.length == 1){
            return new ArrayList<>(){{add(new ArrayList<>(){{add(arr[0]);}});}};
        }



        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            var curr = arr[i];
            var f = Arrays.stream(arr).filter((var a)-> a != curr).toArray(Integer[]::new);

            var temp = solve(f,memo);
            String strF = Arrays.toString(f);
            List<List<Integer>> temp2 = new ArrayList<>();
            for(var t: temp) {
                List<Integer> t2 = new ArrayList<>();
                for(var k: t) t2.add(k);
                temp2.add(t2);
            }
            memo.put(strF, temp2);


            var m = temp.stream().map((var a)-> {
                a.add(0,curr);
                return a;
            }).collect(Collectors.toList());




            ans.addAll(m);
        }


        return ans;

    }


    public static void main (String args[]){
        Map<String,List<List<Integer>>> map = new HashMap<>();
        var a = solve(new Integer[]{1,2,3,4}, map);
        System.out.println(a);


    }
}

/*
[1, 2, 3, 4],
[2, 3, 4, 1],
[3, 4, 1, 2],
[4, 3, 1, 2],
[3, 4, 2, 1],
[1, 2, 4, 3],
[3, 2, 4, 1],
[1, 4, 2, 3],
[4, 1, 3, 2],
[4, 1, 2, 3],
[2, 3, 1, 4],
[2, 1, 3, 4]
 */


