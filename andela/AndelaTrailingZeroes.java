public class AndelaTrailingZeroes {
    //This method find the number of trailing zeroes in factorial of a number
    private static int findTrailingZeros(int n)
    {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5){
            count += n / i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findTrailingZeros(50));
    }
}