package CheatSheet;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class CheatSheet {

    public static void main(String[] args) {

        int [] arr = new int[]{};
                // Piority queue
        PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
        // Piority queue reverse
        PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(10, Collections.reverseOrder());

        // stack
        Stack<Integer> s = new Stack<>();
        // s.pop();
        // deque
        Deque<Integer> d = new LinkedList<>();
        d.offerLast(7);
        d.offerFirst(6);
        d.add(8);
      
        System.out.println(d);
     //   d.removeFirst();
        // queue
        // map
        Map<Integer,Integer> map = new HashMap<>();

        // set
        Set<Integer> set = new HashSet<>();
        set.contains(0);


        Queue<Integer> q = new LinkedList<Integer>();

        // arr to list
        var l = List.of(new Integer[]{});


        // constants

        var v = Integer.MIN_VALUE;
        var v1 = Float. MAX_VALUE;
        var v2 = Double.SIZE;
        var v3 = Boolean.TRUE;

        StringBuilder sb = new StringBuilder("hello");

        //sb.delete(4,5);
        //sb.replace(2,3,"k");



        System.out.println("hello");





        // sorting
        List<Integer> g = new ArrayList<>();
        // min to max
        Collections.sort(g, (a, b) -> a - b);
        //  max to min
        Collections.sort(g, (a, b) -> b - a);

        // binarySearch
        Arrays.binarySearch(new int[]{},8);


       // System.out.println(advancingThroughArray(new int[]{3, 2, 0,0, 2, 0,1},0));
        var x = List.of(new Integer[]{3,2,1,0});
// [[0, 1, 2, 3], [0, 1, 3, 2], [0, 2, 1, 3], [0, 2, 3, 1], [0, 3, 1, 2], [0, 3, 2, 1], [1, 0, 2, 3], [1, 0, 3, 2], [1, 2, 0, 3], [1, 2, 3, 0], [1, 3, 0, 2], [1, 3, 2, 0], [2, 0, 1, 3], [2, 0, 3, 1], [2, 1, 0, 3], [2, 1, 3, 0], [2, 3, 0, 1], [2, 3, 1, 0], [3, 0, 1, 2], [3, 0, 2, 1], [3, 1, 0, 2], [3, 1, 2, 0], [3, 2, 0, 1], [3, 2, 1, 0]]
//        System.out.println(allPermute(x));
//        System.out.println(countAllPermute(x));
        var y = new ArrayList<Integer>();
        y.addAll(x);
//        System.out.println(getNextCompute(y));
       // System.out.println(indexSum(y, 3,3,new HashSet<>()));
       // spiralOdering(new int[3][3]);


        System.out.println("abcdef".substring(1,1+5));
        System.out.println(' ' == " d".charAt(0));
    }

    // get string signature
    private String getSignature(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }

        return sb.toString();
    }


    private static boolean advancingThroughArray(int[] arr, int i){
        if(i == arr.length-1) return true;
  if(arr[i] == 0) {

      return false;
  }
        if( i+1 < arr.length ){

            if(advancingThroughArray(arr, i+1)) return true;
        }
         if( i+arr[i] < arr.length ){

             if(advancingThroughArray(arr, i+arr[i])) return true;
         }

        return false;
    }


    private static List<List<Integer>> allPermute(List<Integer> arr){
        if(arr.size() == 0) return new ArrayList<>(){{add(new ArrayList<>());}};

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {

            int num = arr.get(i);
            var r = new ArrayList<Integer>(arr.size()-1);

            for (int k = 0; k < arr.size(); k++) {
                if(k == i) continue;
                r.add(arr.get(k));
            }

            var x = allPermute(r);

            var temp = x.
                    stream().map((var a ) -> {
                a.add(0,num);
                return a;
            }).collect(Collectors.toList());

            res.addAll(temp);


        }
        return res;
    }



    private static int countAllPermute(List<Integer> arr){
        if(arr.size() == 0) return 1;

        int res = 0;
        for (int i = 0; i < arr.size(); i++) {

            int num = arr.get(i);
            var r = new ArrayList<Integer>(arr.size()-1);

            for (int k = 0; k < arr.size(); k++) {
                if(k == i) continue;
                r.add(arr.get(k));
            }

            var x = countAllPermute(r);

           res+=x;


        }
        return res;
    }


    private static List<Integer> getNextCompute(List<Integer> arr){
// 1,0,3,2

        int lowest =  -1;
        int maxStart = arr.size()-1;

        for (int i = arr.size()-2; i >=0 ; i--) {
            // check previous
            if(arr.get(i) > arr.get(i+1)){
                lowest = (lowest == -1 )?  i+1: lowest;
            }else {
                maxStart = i;
                break;
            }
            if(i == 0){
                return arr;
            }
        }
        if(lowest == -1) {
            Collections.swap(arr,arr.size()-1, arr.size()-2);
            return arr;
        }

        int lowestVal = arr.get(lowest);
        for (int i = lowest; i >= maxStart; i--) {

            if(i == maxStart){
                arr.set(i, lowestVal);

            }else {
                arr.set( i, arr.get(i-1));
            }

        }
return arr;

    }
    private static void spiralOdering(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == 0){

                }

                if(i == arr.length-1){

                }
            }
        }
    }

    private static List<Integer> indexSum(List<Integer> list, int target, int max,Set<Integer> skip){
        if(max == 0) {
            if(target == 0){
                return new ArrayList<>();
            }
   return null;
        }



        for (int i = 0; i < list.size(); i++) {
            var curr = list.get(i);
if(skip.contains(i)) continue;
var newSkip = skip.stream().collect(Collectors.toSet());
            newSkip.add(i);

            var res = indexSum(list, target - curr, max -1,newSkip);



            if(res != null){
                res.add(0,i);
               return res;
            }

        }

        return null;

    }

    public boolean isPalindromeNumber(int x) {
        if(x < 0) return false;


        int revNumber =0;
        int temp = x;

        while (temp!=0){
            revNumber = revNumber*10 + temp%10;
            temp /=10;
        }
        return revNumber == x;


    }


    public int binarySearchInsert(int[] nums, int target) {

        int i = 0;
        int j = nums.length -1;

        while( i <= j){
            int midIndex = (j+i)/2;
            if(nums[midIndex] == target) return midIndex;
            if(nums[midIndex] < target){
                i = midIndex +1;
            }else{
                j = midIndex - 1;
            }

        }

        // System.out.println(i + " " + j);
        return i;

    }




}
