package fireCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RotateSquareImage {

    public static void rotateSquareImageCW(int[][] matrix) {
        Arrays.stream(matrix).forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("transposeMatrix");
        transposeMatrix(matrix);

        System.out.println("flipVerticalAxis");
        flipVerticalAxis(matrix);
    }


    public static void transposeMatrix(int[][] matrix) {
        int n = matrix.length - 1;
        int temp = 0;
        for(int i = 0; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                System.out.println( i+","+j+ " => " + j+","+i);

                Arrays.stream(matrix).forEach(x -> System.out.println(Arrays.toString(x)));
            }
        }
    }


    private static void flipVerticalAxis(int[][] matrix) {
        int n = matrix.length - 1;
        int temp = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j];
                matrix[i][n-j] = temp;


                System.out.println( i+","+j+ " => " + i+","+(n-j));

                Arrays.stream(matrix).forEach(x -> System.out.println(Arrays.toString(x)));
            }
        }
    }


    public static void main (String[] args){
//        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6},{7,8,9}};
//        rotateSquareImageCW(matrix);
        HashSet<Character> x = new HashSet<>();
        x.add('1');
        x.add('2');
        x.add('3');
        x.add('4');
        x.add('4');
        x.add('5');

        System.out.println(x.toString());
        Character[] j = x.toArray(x.toArray(new Character[0]));
        System.out.println(Arrays.toString(j));
    }
}
