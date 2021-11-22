package CheatSheet;

public class BitManipulation {


    public static void main(String[] args) {

        // not operator
        int num = 10;
        System.out.println("- " + num + " = " + Integer.toBinaryString(num));
        int shiftedLeft = num << 1;  // (2*2)* (2*2)
        System.out.println("shiftedLeft - " + shiftedLeft + " = " + Integer.toBinaryString(shiftedLeft));
        int shiftedRight = num >> 1;  // (2*2)* (2*2)
        System.out.println("shiftedRight - " + shiftedRight + " = " + Integer.toBinaryString(shiftedRight));



    }

}
//*
