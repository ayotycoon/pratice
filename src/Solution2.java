
public class Solution2 {
    public static int distinctSubKOdds(int[] arr, int k) {
        // Write your code here!

        return distinctSubKOdds(arr,0,k,0);
    }

    public static int distinctSubKOdds(int[] arr, int k,int j, int count) {
        if(j <0) return 0;
        // Write your code here!

        int ans = 0;
        for(int i =j; i < arr.length; i++){
            int curr = arr[i];
            if(curr %2 == 1){
                count++;
            }
            int res =1;
            if(count <= k){
                res += distinctSubKOdds(arr,i+1,k,count);
            ans+=res;
            }else {
                continue;
            }


        }

        return ans;

    }

    public static void main(String[] args){

        System.out.println(distinctSubKOdds(new int[]{3,2,3},1));
        System.out.println(distinctSubKOdds(new int[]{3,4,5,2,3},1));
    }
}
