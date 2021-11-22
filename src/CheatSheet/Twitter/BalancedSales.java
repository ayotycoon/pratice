package CheatSheet.Twitter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BalancedSales {


    public static int balancedSalesArray(int[] sales) {

        int left = 0;
        int right = 0;
        for(int n: sales) right+=n;

        for(int i =0; i < sales.length; i++){
            int curr = sales[i];

            if(left == right-curr){
                return i;
            }
            left+=curr;
            right-= curr;
        }


        return -1;

    }

    public static void main(String[] args) {

       int[] sales = new int[]{1,2,3,4,6};

        System.out.println(balancedSalesArray(sales));


    }
}
