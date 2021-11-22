import java.util.Arrays;

public class InsertionSort {

    public static void main (String[] args){
        int [] arr = {3,9,1,8,4,7,2};

        for(int i = 1; i < arr.length; i++){
            int a = i;
            int b = i-1;
            while( b >= 0 ){
                if(arr[a] < arr[b]){
                    int curr = arr[b];
                    arr[b]  = arr[a];
                    arr[a] = curr;
                }else {
                    break;
                }

                a--;
                b--;
            }



        }

        System.out.println(Arrays.toString(arr));

    }
}
