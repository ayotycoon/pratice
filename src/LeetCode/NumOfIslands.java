package LeetCode;

import java.util.Arrays;

public class NumOfIslands {

    public static void printGrid(char[][] grid) {

        for (int i=0; i < grid.length; i++){

            for (int j=0; j < grid[i].length; j++) {
                char c = grid[i][j];



                System.out.print(c + ",");


            }

            System.out.println("");

        }
System.out.println("-----------------");

    }
    public static void checkAround(char[][] grid, int i, int j){

        grid[i][j] = '2';

        char charRight = j+1 > (grid[i].length-1) ? 'x' : grid[i][j+1];
        char charLeft = j-1 < 0 ? 'x' : grid[i][j-1];
        char charUp = i-1 < 0 ? 'x' : grid[i-1][j];
        char charDown = i+1 > (grid.length-1) ? 'x' : grid[i+1][j];

        if(charRight == '1'){

            checkAround(grid, i, j+1);
        }
        if(charLeft == '1'){

            checkAround(grid, i, j-1);
        }
        if(charUp == '1'){

            checkAround(grid, i-1, j);
        }
        if(charDown == '1'){

            checkAround(grid, i+1, j);
        }

    }
    public static int numIslands(char[][] grid) {
        int islands = 0;
        for (int i=0; i < grid.length; i++){

            for (int j=0; j < grid[i].length; j++){
                char c = grid[i][j];
                if(c != '1') continue;
                // check all sides for 1

                checkAround(grid,i,j);
                islands++;
                printGrid(grid);

            }
        }
        return islands;
    }

        public static void main(String[] args){
        char[][] grid = {
                {'1','1','1','1','0'},
            {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                    {'0','0','0','0','0'}
        };
            System.out.println("Ans - " +numIslands(grid));







    }

}
