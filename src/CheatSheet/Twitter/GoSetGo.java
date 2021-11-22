package CheatSheet.Twitter;

import java.util.HashMap;
import java.util.Map;

public class GoSetGo {

    public static boolean goSetGo(int[] calories, int required, int i,int tot, Map<Integer, Boolean> map) {
        if (map.containsKey(i)) return map.get(i);
        if(tot == required) return true;
        if (i >= calories.length) return false;


        int calorie = calories[i];



        // i can take this or skip it

        boolean possibility1 = goSetGo(calories, required, i + 1, tot+ calorie, map);
        boolean possibility2 = goSetGo(calories, required,  i + 1,  tot, map);


        boolean ans = possibility1 || possibility2;
        map.put(i, ans);

        return ans;


    }

    public static void main(String[] args) {

//        int[] calories = {2, 9, 5, 1, 6};
//        int required =12;
        int[] calories = {2, 3, 15, 1, 16};
        int required =8;

        Map<Integer,Boolean> map = new HashMap<>();

        System.out.println(goSetGo(calories, required, 0,0, map));





  }
}
