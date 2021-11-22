package dynamic;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Fib {
public static HashMap<Integer,Long> h = new HashMap<>();
public static int t =  0;
    public static Long fibRecur(int n){
        t++;
        if(n <= 1){
            return Long.valueOf(n);
        }
        if(h.containsKey(n)){

            return h.get(n);
        }

        Long x = fibRecur(n-1) + fibRecur(n-2);
        h.put(n,x);

        return x;
    }


    public static void main (String[] args){

        System.out.println(fibRecur(50));

        System.out.println(t);

    }
}

