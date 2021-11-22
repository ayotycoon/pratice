package CrackingTheCodeInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ChildRunning {
    static int[] movements = new int[]{1,2,3};
    static Integer count(int n){

        if (n ==0) return 1;
        if(n < 0) return null;

        int ans = 0;
        // n 2
        for (int i = 0; i < movements.length; i++) {
            int curr = movements[i];

           Integer c =  count(n-curr);
            if(c != null){
                ans+=c;
            }

        }
        return ans;

    }
    static Integer count(int n, HashMap<Integer,Integer> memo){
if(memo.containsKey(n)) return memo.get(n);
        if (n ==0) return 1;
        if(n < 0) return null;

        int ans = 0;
        // n 2
        for (int i = 0; i < movements.length; i++) {
            int curr = movements[i];

           Integer c =  count(n-curr,memo);

            if(c != null){
                ans+=c;
            }
            memo.put(n, ans);
        }
        return ans;

    }

    static ArrayList<Integer> step(int n){

        if (n ==0) return new ArrayList<>();
        if(n < 0) return null;


        // n 2
        for (int i = 0; i < movements.length; i++) {
            int curr = movements[i];

            ArrayList<Integer> c =  step(n-curr);
            if(c != null){
                c.add(curr);
                return c;
            }

        }
return null;

    }
    static ArrayList<Integer> step(int n, HashMap<Integer, ArrayList<Integer>> memo){
if(memo.containsKey(n)) return memo.get(n);
        if (n ==0) return new ArrayList<>();
        if(n < 0) return null;


        // n 2
        for (int i = 0; i < movements.length; i++) {
            int curr = movements[i];

            ArrayList<Integer> c =  step(n-curr, memo);
            if(c != null){
                c.add(curr);
                memo.put(n, c);
                return c;
            }


        }
return null;

    }


    static List<ArrayList<Integer>> allStep(int n){
        List<ArrayList<Integer>> x = new ArrayList<>();
x.add(new ArrayList<>());
        if (n ==0) return x;
        if(n < 0) return null;
        List<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < movements.length; i++) {
            int curr = movements[i];

            List<ArrayList<Integer>> c =  allStep(n-curr);
            if(c != null){
                c = c.stream().map((ArrayList<Integer> a) -> {
                    a.add(curr);
                    return a;
                }).collect(Collectors.toList());


                ans.addAll(c);
            }

        }
        return ans;

    }




    static List<ArrayList<Integer>> allStep(int n, HashMap<Integer,List<ArrayList<Integer>>> memo){
        if(memo.containsKey(n)) return memo.get(n);
        List<ArrayList<Integer>> x = new ArrayList<>();
        x.add(new ArrayList<>());
        if (n ==0) return x;
        if(n < 0) return null;
        List<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < movements.length; i++) {
            int curr = movements[i];

            List<ArrayList<Integer>> c =  allStep(n-curr, memo);
            if(c != null){
                c = c.stream().map((ArrayList<Integer> a) -> {
                    a.add(curr);
                    return a;
                }).collect(Collectors.toList());

memo.put(n, c);
                ans.addAll(c);
            }

        }
        return ans;

    }



    public static void main(String[] args){
      //  System.out.println(count(4, new HashMap<>()));
        // System.out.println(step(4));
        //System.out.println(step(44, new HashMap<>()));
        //System.out.println(allStep(40));
        // System.out.println(allStep(40,new HashMap<>()));
    }
}
