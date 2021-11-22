import java.util.Arrays;

public class BitOperators {



    public static void main(String[] args) {
     // NOT BIT ~
        System.out.println("NOT BIT");
        System.out.println(~5);
        // AND BIT ~
        System.out.println("AND BIT");
        System.out.println(5 & 3);
        // OR BIT ~
        System.out.println("OR BIT");
        System.out.println(5 | 3);
        // LEFT SHIFT ~
        // n << k = (n*2k)
        System.out.println("LEFT SHIFT");
        System.out.println(2<<3);
        // RIGHT SHIFT ~
        // n >> k = (n/2k)
        System.out.println("RIGHT SHIFT");
        System.out.println(10>>3);
        //CHECK IF NUMBER IS DIVISIBE BY 0
        System.out.println("CHECK IF NUMBER IS DIVISIBE BY 0");
        System.out.println(15>>1 != 14>>1);


    }
}
