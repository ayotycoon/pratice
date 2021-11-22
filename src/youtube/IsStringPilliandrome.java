package youtube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class IsStringPilliandrome {

    public static boolean solve(String s){
        s = s.replaceAll(" ", "");
        HashMap<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            var curr = s.charAt(i);
            if(!map.containsKey(curr)){
                map.put(curr, 0);
            }

            map.put(curr, map.get(curr)+1);

        }

        int odd = 0;
        for(Integer value:map.values()){

            if(value % 2 != 0){
                if(odd >0){
                    return false;
                }
                odd++;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String s = "tact coa";


        System.out.println(solve(s));

      ;
    }
}
