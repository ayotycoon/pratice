package dynamic;

import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {

    public static HashMap<Integer,ArrayList<ArrayList<Integer>>> memo = new HashMap<>();

    public static int t = 0;

    public static ArrayList<ArrayList<Integer>> howSumRecur(int n, int[] arr, ArrayList<Integer> track,ArrayList<ArrayList<Integer>> allTrack){


        if(memo.containsKey(n)) return memo.get(n);
        t++;
        if(n == 0) {

           // allTrack.add((ArrayList<Integer>)track.clone());

            return allTrack;
        }
        if(n < 0) {

            return null;
        }
        for (int i = 0; i < arr.length; i++) {

            int c = arr[i];
            int rem = n-c;
            track.add(c);



    var x = howSumRecur(rem,arr,track,allTrack);
    if(x != null && rem == 0){
       // x.remove(x.size()-1);
        x.add((ArrayList<Integer>)track.clone());
    }


    memo.put(rem,x);






            track.remove(track.size()-1);

        }

return allTrack;




    }


    public static void main (String[] args){


        System.out.println(howSumRecur(7, new int[]{5,3,4,7},new ArrayList<Integer>(), new ArrayList<>()));



        System.out.println(t);

    }
}

