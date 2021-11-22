package CheatSheet.Twitter;

import java.util.*;

public class KDifference {
// https://leetcode.com/problems/k-diff-pairs-in-an-array/submissions/
    public static int findPairs(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();


        for(int i=0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new LinkedHashSet<>());
            }
            map.get(nums[i]).add(i);
        }

        for(int i=0; i < nums.length; i++){
            int needed = nums[i] + k;
            if(!map.containsKey(needed)) continue;

            Set<Integer> indexes = map.get(needed);



            for(int j:indexes){
                if(j == i) continue; // do not let it repeat for same index
                String key = nums[i]+" "+ nums[j]; // create the key
                String key2 = nums[j]+" "+ nums[i];// check for the reverse key
                if(set.contains(key) || set.contains(key2))continue; // ifits been done just remove it
                set.add(key);

            }



        }

        // System.out.println(set);
        return set.size();

    }

    public static void main (String[] args){
        int target = 2;
        int[] arr = {1,2,3,4,5,5};

        System.out.println(findPairs(arr,target));

    }


}
