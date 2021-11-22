package CheatSheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CanSum {
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




    public static void main(String[] args) {

        int[] q = new int[]{5, 4, 3, 1, 1,7, 7};
        int target = 7;

        System.out.println("canSumRecur = " + canSumRecur(target, q));
        System.out.println("countSumRecur = " + countSumRecur(target, q));
        System.out.println("howSumRecur = " + howSumRecur(target, q));
        System.out.println("howSumRecurNoDuplicateIndex = " + howSumRecurNoDuplicateIndex(target, q, 0));
        System.out.println("howSumRecurNoDuplicateNumberPerSet = " + howSumRecurNoDuplicateNumberPerSet(target, q, 0, new HashSet<>()));
        System.out.println("howSumRecurNoDuplicateAnswer = " + howSumRecurNoDuplicateAnswer(target, q, 0, new HashSet<>()));
        System.out.println("howSumRecurSubSequence = " + howSumRecurSubSequence(target, q, 0));


    }
}

