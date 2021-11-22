package CheatSheet.Dayo;

import java.util.*;

public class Vanessa {

    private static final Map<Character, Integer> visitedMap = new HashMap<>();
    private static final Map<Character, String> cache = new HashMap<>();

    private static String dfs(Map<Character, LinkedHashSet<Character>> adjMatrix, Character curr) {

        var val = visitedMap.containsKey(curr) ? visitedMap.get(curr) : 0;
        if (val == 1) return "E3";
        if (val == 2) return cache.get(curr);
        visitedMap.put(curr, 1);
        String open = "(" + curr;

        if (!adjMatrix.containsKey(curr)) return open +")";
        LinkedHashSet<Character> values = adjMatrix.get(curr);

        for (var child : values) {
            String temp = dfs(adjMatrix, child);
            if (temp.equals("E3")) return "E3";
            open += temp;
        }
        open += ")";
        cache.put(curr, open);
        visitedMap.put(curr, 2);

        return open;
    }

    private static String solve(String input) {

        Map<Character, LinkedHashSet<Character>> adjMatrix = new LinkedHashMap<>();

        String[] pairs = input.split("\\s+");
        Set<Character> children = new HashSet<>();
        for (String pair : pairs) {
            char parent = pair.charAt(1);
            // append to ParentSet
            char child = pair.charAt(3);
            children.add(child);

            if (!adjMatrix.containsKey(parent)) {
                adjMatrix.put(parent, new LinkedHashSet<>());
            }

            if (adjMatrix.get(parent).contains(child)) return "duplicate endges";

            adjMatrix.get(parent).add(child);
        }
        Character superParent = null;
        for (String pair : pairs) {
            char parent = pair.charAt(1);
            if(superParent != null && superParent == parent) continue;
            if(!children.contains(parent)){

                if(superParent == null){
                    superParent = parent;
                }else {
                    return "duplicate head";
                }

            }

        }




        /*
        0 not
        1 curretly being visited
        2 complete
         */

        for (var entries : adjMatrix.entrySet()) {
            Character key = entries.getKey();
            children.addAll(entries.getValue());

            String ans = dfs(adjMatrix, key);
            if(ans.equals("E3")) return "E3";


        }

System.out.println(cache);
        return  cache.get(superParent);

    }
    public static void main(String[] args) {

        String input = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";


        System.out.println(solve(input));

    }
}
