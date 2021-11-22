package dynamic;



import javax.swing.tree.TreeNode;
import java.util.*;

public class Testerrrrr {

    static int fib(int n){
        if(n <=1) return 1;
        return fib(n-2) + fib(n-1);
    }
    static int gridTraveller(int n,int m){
        if(n ==1) return m;
        if(m ==1) return n;
        if(m == 0 || n == 0) return 0;
        return gridTraveller(n-1, m) + gridTraveller(n, m-1);
    }

    static int gridTravellerAnySize(int[] s){

        int tot = 0;
        for (int i = 0; i < s.length; i++) {
            int x = s[i];
            if(x == 0) continue;
            if(x == 1) {
                tot += s.length-1;
            }else{
                s[i] = --x;

                tot += gridTravellerAnySize(s);
            }





        }

        return tot;
    }

    public static int howSum(int n, int[] m){
        if(n == 0) return 1;
        if(n < 0) return 0;

        int ans = 0;
        for(int i: m){

            ans+=howSum(n-i, m);

        }
        return ans;
    }
    public static ArrayList<Integer> howSum2(int n, int[] m){
        if(n == 0) {
            return new ArrayList<>();
        }
        if(n < 0) return null;
        for(int i = 0; i < m.length; i++){
            int h = m[i];

            ArrayList<Integer> x = howSum2(n-h, m);
            if(x != null ){
                x.add(h);
                return x;
            }
        }
        return null;
    }
   public static ArrayList<Integer> howSum3(int n, int[] m, ArrayList<ArrayList<Integer>> list){
        if(n == 0) {
            return new ArrayList<>();
        }
        if(n < 0) return null;
        for(int i = 0; i < m.length; i++){
            int h = m[i];
            ArrayList<Integer> x = howSum3(n-h, m,list);

            if(x != null){
               x.add(h);

               list.add((ArrayList<Integer>)x.clone());
               return x;
            }
        }
        return null;
    }
public static int a = 0;
    public static ArrayList<Integer> bestSum(int n, int[] m){
        a++;
        if(n == 0) {
            return new ArrayList<>();
        }
        if(n < 0) return null;

        ArrayList<Integer> ans = null;
        for(int i = 0; i < m.length; i++){
            int h = m[i];
            ArrayList<Integer> x = bestSum(n-h, m);



            if(x != null){

               x.add(h);
                if(a <10) System.out.println(x);
                if(ans == null || x.size() < ans.size()){

                  ans = x;
                }
            }

        }
        return ans;
    }    public static boolean canForm(String n, String[] m){

        if(n.equals("")) {
            return true;
        }
        for(int i = 0; i < m.length; i++){
            String h = m[i];
            String r = n.replace(h,"");
            if(!n.equals(r) && n.indexOf(h) == 0){
                return canForm(r, m);
            }
        }
        return false;
    }

    public static int recursiveSum(int[] arr, int i){

        return i > arr.length-1 ? 0 : arr[i] + recursiveSum(arr,++i);
    }

    public static void main(String[] args){

      //  System.out.println("Fib " + fib(5));
      //  System.out.println("GridTraveller " + gridTraveller(3,3));
//
//        var c = new int[]{2, 2};
//        System.out.println("GridTravellerAnySize " + gridTravellerAnySize(c));

      //  System.out.println(howSum2(8, new int[]{2,3,5, 1}));

     //   System.out.println(bestSum(8, new int[]{2,3,5, 1}));
      //  System.out.println(canForm("skateboard", new String[]{"bo","rd","ate","t","ska", "sk","boar"}));


//        System.out.println(new ArrayList<Integer>(4));
//
//        Set<Integer> x = null;
//        var c = x.toArray(new Integer[0]);
//


    }
}
