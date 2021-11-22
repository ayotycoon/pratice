package dynamic;

import java.util.*;
class Solution {
    // i + (j-i)+1

    public static Integer[] solve(String S, int i, int j, Map<String, Integer[]> map) {
        if(map.containsKey(i+" " + j)) return map.get(i+" " + j);

        if(S.charAt(i) == S.charAt(j)) {
            return new Integer[]{i, j};

        }
        Integer[] ans = new Integer[]{0, 0};

        if(i <= j){
            Integer[] possibility1 =  solve(S, i+1, j,map);
            Integer[] possibility2 =  solve(S, i, j-1,map);

            if(possibility1[1] - possibility1[0]  > possibility2[1] - possibility2[0]){
                ans =  possibility1;
            } else if(possibility1[1] - possibility1[0]  < possibility2[1] - possibility2[0]){
                ans =  possibility2;
            }else {


                if(possibility1[0] < possibility2[0]){


                    ans =  possibility1;
                }else {
                    ans = possibility2;
                }

            }


        }

        map.put(i+" " + j, ans);
        return ans;

    }
    public static void main(String[] args) {

        String S = "xxxxxxtcat";

        Integer[] ans = solve(S, 0, S.length() -1, new HashMap<>());



        System.out.println(S.substring(ans[0], ans[0] + (ans[1]-ans[0])+1));


    }
}
