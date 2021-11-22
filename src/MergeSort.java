import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] arr, int a, int mid, int b) {
      //  System.out.println("MergeInput - a-"+a+" b-"+b+" mid -"+ mid +"---"+Arrays.toString(arr));
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        int aStart = a;
        int aEnd = mid;
        int bStart = mid+1;
        int bEnd = b;

        int i = a;
        while (aStart <= aEnd && bStart <= bEnd) {

            if (arrCopy[aStart] < arrCopy[bStart]) {
                arr[i] = arrCopy[aStart];
                aStart++;
            } else {
                arr[i] = arrCopy[bStart];
                bStart++;
            }


            i++;
        }


        while (aStart <= aEnd) {

            arr[i] = arrCopy[aStart];
            aStart++;
            i++;
        }

        while (bStart <= bEnd) {
            arr[i] = arrCopy[bStart];
            bStart++;
            i++;
        }

      //  System.out.println("MergeOutput - a-"+a+" b-"+b+" mid -"+ mid +"---"+Arrays.toString(arr));
    }

    public static void sort(int[] arr,  int a, int b) {
        if(a < b){
            int mid = a + (b-a)/2;
            sort(arr, a, mid);
            sort(arr, mid+1, b);
            merge(arr, a, mid, b);
        }

    }
    public static void main(String[] args) {
        int[] arr = {14, 7, 3, 12, 9, 11, 6, 2};



       sort(arr,0, arr.length-1);

        System.out.println(Arrays.toString(arr));




    }
}
