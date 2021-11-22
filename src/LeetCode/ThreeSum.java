package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

        public static List<List<Integer>> solve(int[] nums, int target, int count, int j) {


            if(count == 0){
                if(target == 0){
                    List<List<Integer>> z = new ArrayList<>();
                    z.add(new ArrayList<Integer>());
                    return z;

                }else {
                    return null;
                }
            }

            List<List<Integer>> ans = new ArrayList<>();


            for(int i =j; i < nums.length; i++){

                int curr = nums[i];

               // if( i != 0 && j ==0 && nums[i-1] == curr) continue;
                List<List<Integer>> possibilities = solve(nums,target + curr, count -1, i+1 );
                if(possibilities != null){

                    List<List<Integer>> newPossibilities = new ArrayList<>();

                    for(List<Integer> possibility: possibilities){
                        possibility.add(curr);
                        newPossibilities.add(possibility);

                    }



                    ans.addAll(newPossibilities);
                }

            }


            return ans;
        }

    public ThreeSum() {
    }

    public static void main (String[] args) {
//            int [] nums = new int[]{-1,0,1,2,-1,-4};
//            System.out.println(solve(nums, 0,3,0));

            // [[-1,-1,2],[-1,0,1]]
//
//
//var g = new StringBuilder("ddbbcccbda");
//
//g.delete(2, 4);
//            System.out.println(g);

//
       int[][] test = {{6,2}, {1,4}};

       int[] nums = {6,2,7};
//
//
//        var x = Arrays.stream(nums).boxed()
//                .sorted(Collections.reverseOrder())
//                .mapToInt(Integer::intValue)
//                .toArray();
//        System.out.println(Arrays.toString(x));
//            System.out.println(Arrays.toString(Arrays.stream(test).map((var a)-> Arrays.toString(a)).toArray()));
//

//            ArrayList<Integer[]> ans = new ArrayList<>();
//
//            var f = ans.toArray(new Integer[0][0]);

//            int[] a = {3,2,3,1,2,4,5,5,6};
//            Arrays.sort(a);
//            int[] b = {3,2,1,5,6,4};
//            Arrays.sort(b);
//
//            System.out.println(Arrays.toString(a));
//            System.out.println(Arrays.toString(b));


        }

}
