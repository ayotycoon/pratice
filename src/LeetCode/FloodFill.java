package LeetCode;

public class FloodFill {

    public static void printGrid(int[][] grid) {

        for (int i=0; i < grid.length; i++){

            for (int j=0; j < grid[i].length; j++) {
                int c = grid[i][j];



                System.out.print(c + ",");


            }

            System.out.println("");

        }
System.out.println("-----------------");

    }


    public static void checkAround(int[][] grid, int i, int j,int newColor){
        int curr = grid[i][j];


        grid[i][j] = newColor;

        printGrid(grid);

        int charRight = j+1 > (grid[i].length-1) ? -1 : grid[i][j+1];
        int charLeft = j-1 < 0 ? -1 : grid[i][j-1];
        int charUp = i-1 < 0 ? -1 : grid[i-1][j];
        int charDown = i+1 > (grid.length-1) ? -1 : grid[i+1][j];

        if(charRight ==curr){
            System.out.println("Right");
            checkAround(grid, i, j+1,newColor);
        }
        if(charLeft == curr){
            System.out.println("Left");
            checkAround(grid, i, j-1,newColor);
        }
        if(charUp == curr){
            System.out.println("Up");
            checkAround(grid, i-1, j,newColor);
        }
        if(charDown == curr){
            System.out.println("Down");
            checkAround(grid, i+1, j,newColor);
        }

    }




        public static void main(String[] args){
        int[][] grid = {{1,1,1},{1,1,0},{1,0,1}};
        int sr =1;
        int sc = 1;
        int newColor = 2;

            checkAround(grid, sr,sc,newColor);


            System.out.println("Ans - " +grid);







    }

}
