import java.util.Arrays;

public class RecursiveStaircase {

public static int solveRecur(int n){
    if(n <= 1){
        return 1;
    }

    return solveRecur(n-1) + solveRecur(n-2);
}
public static int solveDynamic(int n){
    if(n <= 1){
        return 1;
    }
    int[] ans = new int[n+1];
    ans[0] = 1;ans[1] = 1;

    for (int i = 2; i < ans.length; i++){
        ans[i] = ans[i-1] + ans [i-2];

    }
    System.out.println(Arrays.toString(ans));
    return ans[n];
}

    public static void main(String[] args) {
    int n = 5;

    System.out.println(solveDynamic(n));

    }
}
