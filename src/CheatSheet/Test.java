package CheatSheet;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static HashMap<String, Integer> h = new HashMap<>();

    public static Boolean canSumRecur(int n, int[] arr) {
        if (n == 0) return true;


        for (int num : arr) {
            if ((n - num) < 0 || (n - num) == n) continue;

            var ans = canSumRecur(n - num, arr);
            if (ans) return true;

        }


        return false;


    }


    public static int countSumRecur(int n, int[] arr) {
        if (n == 0) return 0;


        int ans = 0;
        for (int num : arr) {
            if ((n - num) < 0 || (n - num) == n) continue;

            ans += countSumRecur(n - num, arr) + 1;


        }


        return ans;


    }


    public static ArrayList<ArrayList<Integer>> howSumRecur(int n, int[] arr) {
        if (n == 0) return new ArrayList<>() {{
            add(new ArrayList<>());
        }};


        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int num : arr) {
            if ((n - num) < 0 || (n - num) == n) continue;

            ans.addAll(howSumRecur(n - num, arr).stream().map(a -> {
                a.add(0, num);

                return a;

            }).collect(Collectors.toList()));


        }


        return ans;


    }


    public static ArrayList<ArrayList<Integer>> howSumRecurNoDuplicateNumberPerSet(int n, int[] arr) {
        if (n == 0) return new ArrayList<>() {{
            add(new ArrayList<>());
        }};


        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int num : arr) {
            if ((n - num) < 0 || (n - num) == n) continue;

            ans.addAll(howSumRecurNoDuplicateNumberPerSet(n - num, arr).stream().map(a -> {
                a.add(0, num);

                return a;

            }).collect(Collectors.toList()));


        }


        return ans;


    }


    public static ArrayList<ArrayList<Integer>> howSumRecurNoDuplicateIndex(int n, int[] arr, int j) {
        if (n == 0) return new ArrayList<>() {{
            add(new ArrayList<>());
        }};


        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = j; i < arr.length; i++) {
            int num = arr[i];
            if ((n - num) < 0 || (n - num) == n) continue;

            ans.addAll(howSumRecurNoDuplicateIndex(n - num, arr, i + 1).stream().map(a -> {
                a.add(0, num);

                return a;

            }).collect(Collectors.toList()));


        }


        return ans;


    }


    public static ArrayList<ArrayList<Integer>> howSumRecurSubSequence(int n, int[] arr, int j) {
        if (n == 0) return new ArrayList<>() {{
            add(new ArrayList<>());
        }};


        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = j; i < arr.length; i++) {
            int num = arr[i];
            if ((n - num) < 0 || (n - num) == n) break;

            ans.addAll(howSumRecurSubSequence(n - num, arr, i + 1).stream().map(a -> {
                a.add(0, num);

                return a;

            }).collect(Collectors.toList()));


        }


        return ans;


    }


    public static ArrayList<ArrayList<Integer>> howSumRecurNoDuplicateNumberPerSet(int n, int[] arr, int j, Set<Integer> dup) {
        if (n == 0) return new ArrayList<>() {{
            add(new ArrayList<>());
        }};


        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = j; i < arr.length; i++) {
            int num = arr[i];
            if ((n - num) < 0 || (n - num) == n) continue;
            if (dup.contains(num)) continue;
            Set<Integer> newDup = dup.stream().collect(Collectors.toSet());
            newDup.add(num);
            ans.addAll(howSumRecurNoDuplicateNumberPerSet(n - num, arr, i + 1, newDup).stream().map(a -> {
                a.add(0, num);

                return a;

            }).collect(Collectors.toList()));


        }


        return ans;


    }




    public static ArrayList<ArrayList<Integer>> howSumRecurNoDuplicateAnswer(int n, int[] arr, int j, Set<String> dup) {
        if (n == 0) return new ArrayList<>() {{
            add(new ArrayList<>());
        }};


        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = j; i < arr.length; i++) {
            int num = arr[i];
            if ((n - num) < 0 || (n - num) == n) continue;
            if (dup.contains(num)) continue;

            var res = howSumRecurNoDuplicateAnswer(n - num, arr, i + 1, dup).stream().map(a -> {
                a.add(0, num);

                return a;

            }).collect(Collectors.toList());
            if(dup.contains(res.toString())) continue;
            ans.addAll(res);
            dup.add(res.toString());


        }


        return ans;


    }

private static Map<String, Integer> map = new HashMap<>();
    public static int dfs(int [][] board, int i, int j){
        String key = i+" " +j;
        if(map.containsKey(key)) return map.get(key);
        if(i >= board.length || j >= board[0].length ) return Integer.MAX_VALUE;
        int curr = board[i][j];
        if(i == board.length-1 && j == board[0].length -1) return curr;

        int ans = curr;
        int possibility1 = dfs(board, i+1,j);
        int possibility2 = dfs(board, i,j+1);
        ans += Math.min(possibility1,possibility2);

        map.put(key, ans);
        return ans;

    }
    public static int getCharNum(char c){
        if(c == '0') return 1;
        if(c == '1') return 2;
        if(c == '2') return 3;
        return 5;
    }

    public static int dfsChar(char [][] board, int i, int j){
        if(i >= board.length || j >= board[0].length ) return Integer.MAX_VALUE;
        char _curr = board[i][j];
        int curr = getCharNum(_curr);
        if(i == board.length-1 && j == board[0].length -1) return curr;

        int ans = curr;

        int possibility1 = dfsChar(board, i+1,j);
        int possibility2 = dfsChar(board, i,j+1);
        ans += Math.min(possibility1,possibility2);

        return ans;

    }


    public static int dfs2(int [][] board, int i, int j, int mI,int mJ,int nI, int nJ){

        int curr = board[i][j];
        if(i == nI && j == nJ) return curr;

        int ans = curr;

        if(i+1 <= nI && j+1 <= nJ){
            int possibility1 = dfs2(board, i+1,j,mI,mJ,nI,nJ);
            int possibility2 = dfs2(board, i,j+1,mI,mJ,nI,nJ);


            ans += Math.min(possibility1,possibility2);
        }else if(i+1 <= nI){
            ans+=dfs2(board, i+1,j,mI,mJ,nI,nJ);
        }else if(j+1 <= nJ){
            ans+=dfs2(board, i,j+1,mI,mJ,nI,nJ);
        }



        return ans;

    }


    public static void main(String[] args) {
/*
        int[] q = new int[]{5, 4, 3, 1, 1,7, 7};
        int target = 7;

        System.out.println("canSumRecur = " + canSumRecur(target, q));
        System.out.println("countSumRecur = " + countSumRecur(target, q));
        System.out.println("howSumRecur = " + howSumRecur(target, q));
        System.out.println("howSumRecurNoDuplicateIndex = " + howSumRecurNoDuplicateIndex(target, q, 0));
        System.out.println("howSumRecurNoDuplicateNumberPerSet = " + howSumRecurNoDuplicateNumberPerSet(target, q, 0, new HashSet<>()));
        System.out.println("howSumRecurNoDuplicateAnswer = " + howSumRecurNoDuplicateAnswer(target, q, 0, new HashSet<>()));
        System.out.println("howSumRecurSubSequence = " + howSumRecurSubSequence(target, q, 0));

*/
        /*
        String s = "helloworld"; // = 2
        int dot = 3;
        // any letter 6

        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()) set.add(c);
        */

//int [][] board = new int[][]{
//        new int[]{0,0,3,6,0},
//        new int[]{1,3,3,6,9},
//        new int[]{1,1,3,0,6},
//        new int[]{1,5,0,0,6},
//        new int[]{1,0,0,0,0}
//};


//        char [][] board = new char[][]{
//                new char[]{'0','0','1','2','0'},
//                new char[]{'0','0','1','2','0'},
//                new char[]{'0','0','1','2','0'},
//                new char[]{'0','0','1','2','0'},
//                new char[]{'0','0','1','2','0'}
//
//
//        };

int mI = 2;
int mJ = 1;
int nI = 4;
int nJ = 4;



//var test = dfs2(board, mI,mJ,mI,mJ,nI,nJ);


        int [][] board = new int[][]{
                new int[]{1,0,1,0},
                new int[]{1,5,2,0},
                new int[]{2,6,7,0},

        };




        var test = dfs(board, 0,0);

System.out.println(test);

    }

    static int dfs(int[][] grid, int row, int col, int target){
        // if out of bounds
        if(row <0 || row >= grid.length || col < 0 || col >= grid[0].length) return 0;
        // if i have visited it
        if(grid[row][col] == -1) return 0;

        // if it is not target
        if(grid[row][col] != target) return 0;
        // set it as visited
        grid[row][col] = -1;

        int right = dfs(grid,  row,  col+1, target); // check right
        int left = dfs(grid,  row,  col-1, target); // check left
        int up  = dfs(grid,  row-1,  col, target); // check up
        int down  = dfs(grid,  row+1,  col, target); // down

        return 1+ right + left + up+ down;// increment




    }
}
//*
