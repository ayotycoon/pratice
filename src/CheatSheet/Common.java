package CheatSheet;

public class Common {

    private static int solve(String s1, String s2, int i, int j){
        int max = 0;
        if(i >= s1.length()) return max;
        if(j >= s2.length()) return max;

        char charAt1 = s1.charAt(i);
        char charAt2 = s2.charAt(j);

        if(charAt1 == charAt2){

            max = Math.max(max,1 + solve(s1, s2, i + 1, j + 1));
        }else {
            int posibility1 = solve(s1,s2,i+1,j);
            int posibility2 = solve(s1,s2,i,j+1);

           if(i -1 >= 0 && j-1 >=0 && s1.charAt(i-1) != s2.charAt(j-1)){

                return 0;
            }


            max = Math.max(max, Math.max(posibility1,posibility2));
        }

        return max;
    }

    public static void main(String[] args){
        String s1 = "ayotycoyon";
        String s2 = "xcoont";

        System.out.println(solve(s1,s2,0,0));
    }
}
