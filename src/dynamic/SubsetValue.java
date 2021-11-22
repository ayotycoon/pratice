package dynamic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SubsetValue {

    public static Boolean subsetValueBoolean(int[] arr, int val){

        if(val == 0) return true;
        if(val < 0) return false;




        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];


            if(subsetValueBoolean(arr,val-curr)){
                return true;
            }

        }
return false;

    }

    public static Boolean subsetValueUniqueBoolean(int[] arr, int val,HashMap<Integer,Boolean> map){

        if(val == 0) return true;
        if(val < 0) return false;




        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            if(map.containsKey(curr)){
                continue;
            }else {
                map.put(curr,true);
            }

            if(subsetValueUniqueBoolean(arr,val-curr, map)){
                return true;
            }

        }
return false;

    }


    public static ArrayList<Integer> subsetValueFirstHow(int[] arr, int val){

        if(val == 0) return new ArrayList<>();
        if(val < 0) return null;
       // var ans = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            var x = subsetValueFirstHow(arr,val-curr);

            if(x != null){
                x.add(curr);
return x;
            }

        }
        return  null;

    }



    public static ArrayList<Integer> subsetValueFirstUniqueHow(int[] arr, int val, HashMap<Integer,Boolean> map){

        if(val == 0) return new ArrayList<>();
        if(val < 0) return null;
       // var ans = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if(map.containsKey(curr)){
                continue;
            }

            map.put(curr,true);

            var x = subsetValueFirstUniqueHow(arr,val-curr,map);

            if(x != null){
                x.add(curr);
return x;
            }

        }
        return  null;

    }


    public static ArrayList<ArrayList<Integer>> guy =  new ArrayList<ArrayList<Integer>>();

    public static ArrayList<ArrayList<Integer>> subsetValueAllHow(int[] arr, int val){
var t = new ArrayList<ArrayList<Integer>>();
t.add(new ArrayList<Integer>());


        if(val == 0) return t;
        if(val < 0) return null;


        var ans = new ArrayList<ArrayList<Integer>>();



        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];



            var x = subsetValueAllHow(arr,val-curr);

            if(x != null){
                var y = x.stream().map((ArrayList<Integer> a) -> {
                    a.add(curr);
                    return a;
                }).collect(Collectors.toList());

ans.addAll(y);


            }

        }

        return  ans;

    }


    public static ArrayList<ArrayList<Integer>> subsetValueAllUniqueHow(int[] arr, int val, int j){
var t = new ArrayList<ArrayList<Integer>>();
t.add(new ArrayList<Integer>());
        if(val == 0) return t;
        if(val < 0) return null;


        var ans = new ArrayList<ArrayList<Integer>>();



        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];



            var x = subsetValueAllUniqueHow(arr,val-curr,j);

            if(x != null){
                var y = x.stream().map((ArrayList<Integer> a) -> {
                    a.add(curr);
                    return a;
                }).collect(Collectors.toList());

ans.addAll(y);

            }

        }

        return  ans;

    }



    public static Integer subsetValueLowestUnique(int[] arr, int val, int j){

        if(val == 0) return 0;
        if(val < 0) return null;


        var ans = 99999;



        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];



            var x = subsetValueLowestUnique(arr,val-curr,j);

            if(x != null){
                var y = x+1;

                if(y< ans){
                    ans = y;
                }


            }

        }

        return  ans;

    }




    public static void main(String[] args){


       // System.out.println(subsetValueBoolean(new int[]{3,5,2,2,1}, 8));
       // System.out.println(subsetValueUniqueBoolean(new int[]{3,5,2,2,1}, 8, new HashMap<>()));
        // System.out.println(subsetValueFirstHow(new int[]{3,5,2,1}, 8));
       // System.out.println(subsetValueFirstUniqueHow(new int[]{3,5,2,1}, 8,new HashMap<>()));
      //  System.out.println(subsetValueAllUniqueHow(new int[]{3,5,2,1}, 8,0));
      // System.out.println(subsetValueAllUniqueHow(new int[]{3,5,2,1}, 8,0));
       System.out.println(subsetValueLowestUnique(new int[]{3,5,2,8}, 8,0));


      // System.out.println("abcdea".("a",""));

    }
}
