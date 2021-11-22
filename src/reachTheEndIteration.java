import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class reachTheEndIteration {
    static Stack<Integer[]> s = new Stack<>();
    public  static void solve(char[][] input){
        var first = new Integer[]{0, 0,0};
        s.add(first);

        while(!s.isEmpty()){
            var curr = s.pop();
            System.out.println(Arrays.toString(curr));
            if(curr[0] == input.length-1 && curr[1] == input[0].length-1){
                System.out.println("ans is "+ curr[2]);
            }

            // if has right
            if(curr[1] + 1 < input[0].length && input[curr[0]][curr[1] + 1] == '.'){
                s.add(new Integer[]{curr[0],curr[1]+1,curr[2]+1} );
            }

            // if has left
            if(curr[0] + 1 < input.length && input[curr[0]+1][curr[1]] == '.'){
                s.add(new Integer[]{curr[0]+1,curr[1],curr[2]+1});
            }
        }


    }

    public static void main (String[] args){
        char[][] input = {
        {'.','.','#'},
        {'#','.','#'},
        {'.','.','.'},
    };

        solve(input);
    }
}
