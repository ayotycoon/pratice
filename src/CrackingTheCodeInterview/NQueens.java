package CrackingTheCodeInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class NQueens {

    static boolean  checker (Integer[][] board, int n, int i, int j ) {


        // go down i
        for (int y = 0; y < n; y++) {

            if(board[y][j] != null){
                return false;
            }
        }
        // go right i
        for (int x = 0; x < n; x++) {

           if(board[i][x]  != null){
               return false;
           }
        }

        // go diagonal down
        int x = j-1;
        int y = i-1;
        while  (x >=0 && x<n && y<n&&  y>=0 ){
         //   System.out.println("i "+ i + " j "+j+" y "+y+" x "+ x);
           if(board[y][x]  != null){
               return false;
           }

           x--;
           y--;
        }


            // go diagonal up
        int _x = j+1;
        int _y = i-1;
        while  (_x >= 0 && _x<n && _y<n&&  _y >= 0){
          //  System.out.println("i "+ i + " j "+j+"x = " + _x + " y = "+ _y);
           if(board[_y][_x]  != null){
               return false;
           }

           _x++;
           _y--;
        }
        return true;


    }
    static ArrayList<Integer[][]> solve (int n , HashMap<String,Boolean> map) {

        var board = new Integer[n][n];

        int put = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j< n; j++) {
                // printBoard(board);
                var key = i+","+j;
                var val = checker(board, n, i, j);
                if(val && !map.containsKey(key)){
                    System.out.println(i);
                    put++;

                    if(map.isEmpty()){
                        map.put(key,true);
                    }

                    board[i][j] = 1;

                    break;
                }else {
                    board[i][j] = null;
                }
            }
        }
        var w = new ArrayList<Integer[][]>();

           w.addAll(solve(n,map));

           if(put == n){
               w.add(board);
           }

          return w;





    }

    public static void printBoard(Integer[][] ans){
        System.out.println(Arrays.toString(Arrays.stream(ans).map((var a)-> "\n" +Arrays.toString(a)).collect(Collectors.toList()).toArray()));

    }

    public static void main (String[] args){
      int n = 8;
        HashMap<String, Boolean> map = new HashMap<>();
      var ans = solve(n,map);

    ans.stream().forEach((var a) -> printBoard(a));

    }

}
