package CheatSheet.Dayo;

import java.util.ArrayList;
import java.util.List;

class DoubleReturn{
    public List<Integer> list = null;
    public Integer count = 0;
}

public class Level1 {

    public static List<Integer> findMinPath(int[][] board, int i, int j){
        if(i == board.length && j == board.length) return new ArrayList<>();
        if(i >= board.length || j >= board.length) return null;


        List<Integer> ans = new ArrayList<>();

        int curr = board[i][j];
        List<Integer> possibility1  = findMinPath(board, i+1, j);
        List<Integer> possibility2  = findMinPath(board, i, j+1);
        if(possibility1 == null && possibility2 == null) return new ArrayList<>(){{add(curr);}};
        if(possibility1 == null) {
            possibility2.add(0,curr);
            return possibility2;
        }
        if(possibility2 == null) {
            possibility1.add(0,curr);
            return possibility1;
        }


        int p1 = 0;
        int p2 = 0;
        for(int x: possibility1 ){
            p1+=x;
        }
        for(int x: possibility2 ){
            p2+=x;
        }
        if(p1 < p2){
            ans =possibility1;
        }else {
            ans = possibility2;
        }


        ans.add(0,curr);

        return ans;


    }
    // n * n
    /*

    [4,9,0]
    [1,7,7]
    [5,0,1]

    [7, 7 ]
    [0, 1]


     */

    public static void main (String[] args){
   int[][] question = new int [][]{
           new int[]{4,9,0},
           new int[]{1,7,7},
           new int[]{5,0,1}
   };
        System.out.println(findMinPath(question,0, 0));

    }
}
