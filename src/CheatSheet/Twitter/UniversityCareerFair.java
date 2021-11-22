package CheatSheet.Twitter;

import java.util.HashMap;
import java.util.Map;

public class UniversityCareerFair {

    public static int universityCareerFair(int[] arrivals, int[] durations, int i, int prev, Map<Integer, Integer> map) {
        if (map.containsKey(i)) return map.get(i);
        if (i >= durations.length) return 0;

        int arrival = arrivals[i];
        int duration = durations[i];
        if (prev >= arrival + duration) {

            return 0;
        }
        int count = 0;

        // i can take this or skip it

        int possibility1 = universityCareerFair(arrivals, durations, i + 1, arrival + duration, map) + 1;
        int possibility2 = universityCareerFair(arrivals, durations, i + 1, prev, map);


        count += (Math.max(possibility1, possibility2));
        map.put(i, count);

        return count;


    }

    public static void main(String[] args) {

        int[] arrival = {1,3,3,5,7, 6, 9};
        int[] duration = {2,2,1,2,1, 10, 2};

        Map<Integer,Integer> map = new HashMap<>();

        System.out.println(universityCareerFair(arrival, duration, 0, 0, map));





  }
}
