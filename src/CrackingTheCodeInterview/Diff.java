package CrackingTheCodeInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Diff {

    public static List<Integer[]>  solveBrute(int[] arr, int k){


        List<Integer[]> ans = new ArrayList<>();

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            map.put(curr,true);

        }
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int upper = curr+k;
          //  int lower = curr-k;

            if(map.containsKey(upper)){
                ans.add(new Integer[]{curr, upper});
            }


        }
        // 1,2,3,4,7,9

        return ans;
    }


    public static List<Integer[]>  solveBinarySearch(int[] arr, int k){

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        List<Integer[]> ans = new ArrayList<>();

        int left = 0, right = 1;

        while(left < arr.length-1 &&  right < arr.length -1){
            System.out.println("l="+left+" r="+right);

            int numAtLeft = arr[left];
            int numAtRight = arr[right];
            int diff = numAtRight - numAtLeft;
            if(diff == k){
                ans.add(new Integer[]{numAtLeft,numAtRight});
                right++;
            }else if (diff < k){
                right++;
            }else {
                left++;
            }
        }

        return ans;
    }


    public static void main (String[] args){
        int [] arr = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        solveBrute(arr,k).stream().forEach((Integer[] a)-> System.out.println(Arrays.toString(a)));
        System.out.println("------------------");
      solveBinarySearch(arr,k).stream().forEach((Integer[] a)-> System.out.println(Arrays.toString(a)));
 }
}
