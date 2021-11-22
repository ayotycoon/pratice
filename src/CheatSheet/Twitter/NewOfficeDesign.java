package CheatSheet.Twitter;

import java.util.HashMap;
import java.util.Map;

public class NewOfficeDesign {

    public static int newOfficeDesign(int[] tablePositions, int[] tableHeights, int i, int prev, Map<Integer, Integer> map) {
        if (map.containsKey(i)) return map.get(i);
        if (i >= tableHeights.length) return 0;

        int tablePosition = tablePositions[i];
        int tableHeight = tableHeights[i];
        if (prev >= tablePosition + tableHeight) {

            return 0;
        }
        int count = 0;

        // i can take this or skip it

        int possibility1 = newOfficeDesign(tablePositions, tableHeights, i + 1, tablePosition + tableHeight, map) + 1;
        int possibility2 = newOfficeDesign(tablePositions, tableHeights, i + 1, prev, map);


        count += (Math.max(possibility1, possibility2));
        map.put(i, count);

        return count;


    }

    public static void main(String[] args) {

        int[] tablePosition = {1,3,3,5,7, 6, 9};
        int[] tableHeight = {2,2,1,2,1, 10, 2};

        Map<Integer,Integer> map = new HashMap<>();

        System.out.println(newOfficeDesign(tablePosition, tableHeight, 0, 0, map));





  }
}
