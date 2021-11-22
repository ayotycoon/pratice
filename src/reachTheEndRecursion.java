import java.util.Arrays;
import java.util.Stack;

public class reachTheEndRecursion {
    public static int recur(Integer[] curr,char[][] input){
        if(curr == null|| curr[0] == input.length-1 && curr[1] == input[0].length-1){
            return 0;
        }

        Integer[] right = null;
        // if has right
        if(curr[1] + 1 < input[0].length && input[curr[0]][curr[1] + 1] == '.'){
            right = new Integer[]{curr[0],curr[1]+1};
        }

        Integer[] left = null;
        // if has left
        if(curr[0] + 1 < input.length && input[curr[0]+1][curr[1]] == '.'){
            left = new Integer[]{curr[0]+1,curr[1]};
        }

        return Math.max(recur(right, input), recur(left, input)) + 1;
    }
    public  static void solve(char[][] input){
    var ans = recur(new Integer[]{0,0}, input);

    System.out.println("ans is " + ans);
    }

    public static void main (String[] args){
        char[][] input = {
        {'.','.','#'},
        {'#','.','#'},
        {'.','.','.'},
        {'.','.','.'},
    };


        solve(input);
    }




}
