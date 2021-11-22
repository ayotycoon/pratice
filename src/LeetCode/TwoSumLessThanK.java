package LeetCode;

import java.util.Arrays;

public class TwoSumLessThanK {


    public static int twoSumLessThanK(int[] A, int K) {
        // Sort the array first
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));

        // Put pointers at begin/end and shrink
        int l = 0, r = A.length - 1;
        int ans = -1;
        while(l < r) {
            System.out.println("l="+l+" r="+r);
            if(A[l] + A[r] < K) {
                ans = Math.max(ans, A[l] + A[r]);
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args){
System.out.println(twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8},60));
    }
}
