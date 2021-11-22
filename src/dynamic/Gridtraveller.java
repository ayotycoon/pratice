package dynamic;

import java.util.HashMap;

public class Gridtraveller {
public static HashMap<String,Integer> h = new HashMap<>();

    public static Integer travellerRecur(int n, int m){
        System.out.println(n+","+m);

        if(n == 0 || m == 0){
            return 0;
        }
        if(n == 1 || m == 1){

            return 1;
        }
        if(h.containsKey(n +","+m)){
            return h.get(n +","+m);
        }
        if(h.containsKey(m +","+n)){
            return h.get(m +","+n);
        }

        Integer x =travellerRecur(n-1,m) + travellerRecur(n, m-1);
        h.put(n +","+m,x);

        return x;
    }


    public static void main (String[] args){

        System.out.println(travellerRecur(18, 18));



    }
}

