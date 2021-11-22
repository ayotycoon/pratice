package CheatSheet.Twitter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Subpalindrome {
    private static final Map<String, Boolean> palMap = new HashMap<String, Boolean>();
    private static final Set<String> set = new LinkedHashSet<>();

    public static boolean isPalindrome(String s, int i, int j) {
        String key = i + " " + j;
        if (palMap.containsKey(key)) return palMap.get(key);
        if (i > j) return true;

        boolean ans;
        if (s.charAt(i) != s.charAt(j)) {
            ans = false;
        } else {
            ans = isPalindrome(s, i + 1, j - 1);
        }


        palMap.put(key, ans);
        return ans;

    }

    public static int subpalindrome(String s, int i, int j, Map<Integer, Boolean> map) {
        if (i > j) return 0;
        String key = i + " " + j;
        if(set.contains(key) ) return 0;


        boolean isPal = isPalindrome(s, i, j);
        if (isPal) {
            String substr = s.substring(i, j +1);

            if(set.contains(substr)){
                isPal = false;
            }else {
                set.add(substr);
            }
            set.add(key);

        }
        int ans = isPal ? 1 : 0;

        int possibility1 = subpalindrome(s, i + 1, j, map);
        int possibility2 = subpalindrome(s, i, j - 1, map);

        ans += (possibility1 + possibility2);

        return ans;


    }

    public static void main(String[] args) {

//        int[] calories = {2, 9, 5, 1, 6};
//        int required =12;

        String s = "mokkori";
        Map<Integer, Boolean> map = new HashMap<>();
        System.out.println(subpalindrome(s, 0, s.length() - 1, map));


    }
}
