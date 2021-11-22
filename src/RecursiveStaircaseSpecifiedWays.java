import java.util.Arrays;

public class RecursiveStaircaseSpecifiedWays {

public static int solveRecur(int n){
    if(n <= 2){
        return 1;
    }
    if(n == 3){
        return 2;
    }

    return solveRecur(n-1) + solveRecur(n-3);
}
public static int solveDynamic(int n){
    if(n <= 1){
        return 1;
    }
    int[] ans = new int[n];
    ans[0] = 1;ans[1] = 1;ans[2] = 2;

    for (int i = 3; i < ans.length; i++){
        ans[i] = ans[i-1] + ans [i-3];

    }
System.out.println(Arrays.toString(ans));
    return ans[n-1];
}

    public static void main(String[] args) {
    int n = 7;

    System.out.println(solveDynamic(n));

    }
}

/*
{1,3}
1 => 1
2 => 1
3 => 2
4 => 3
5 => 4
6 => 6

 */
