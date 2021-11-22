package CheatSheet.Twitter;

import java.util.HashMap;
import java.util.Map;

public class CanReach {

    public static boolean canReach(int x1, int y1, int x2, int y2, Map<String, Boolean> map) {

        String key = x1 + " " + y1;
        System.out.println(key);
        if (map.containsKey(key)) return map.get(key);
        if (x1 == x2 && y1 == y2) return true;
        if (x1 > x2 || y1 > y2) return false;

        boolean a = canReach(x1 + y1, y1, x2, y2, map);
        boolean b = canReach(x1, y1 + x1, x2, y2, map);

        var ans = a || b;


            System.out.println(key + " ------- "+ans+" prev = " + map.get(key));

        map.put(key, ans);
        return ans;

    }

    public static void main(String[] args) {


        System.out.println(canReach(35, 13, 455955547, 420098884, new HashMap<>()));
    }
}
