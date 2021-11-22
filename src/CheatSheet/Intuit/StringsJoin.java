package CheatSheet.Intuit;

import java.util.*;
import java.util.stream.Collectors;

public class StringsJoin {
    public static List<List<String>> solveFull(List<String> arr, String track, Map<String, List<List<String>>> map){
String key = arr.toString();
if (map.containsKey(key)){
    System.out.println( " - "+ map.get(key));
        }
        List<List<String>> ans = new ArrayList<>();


        for(int i =0; i < arr.size(); i++){
            String curr = arr.get(i);
            char currFirst = curr.charAt(0);

            if(track!= null && currFirst != track.charAt(track.length()-1)) continue;
            var newArr = arr.stream().filter((var a)-> !a.equals(curr)).collect(Collectors.toList());
            var temp = solveFull(newArr, curr,map).stream().map((var a) -> {
                a.add(0,curr);
                return a;
            }).collect(Collectors.toList());

            ans.addAll(temp);

        }
        if(ans.size() == 0){
            ans.add(new ArrayList<>());
        }
  map.put(key, ans);
        return ans;
    }

    public static List<String> solveMax(List<String> arr, String track, Map<String, List<String>> map){
        String key = arr.toString();
        if (map.containsKey(key)){
            return  map.get(key);
        }
        List<String> ans = new ArrayList<>();


        for(int i =0; i < arr.size(); i++){
            String curr = arr.get(i);
            char currFirst = curr.charAt(0);

            if(track!= null && currFirst != track.charAt(track.length()-1)) continue;
            var newArr = arr.stream().filter((var a)-> !a.equals(curr)).collect(Collectors.toList());
            var temp = solveMax(newArr, curr,map);

            temp.add(0,curr);

            if(temp.size() > ans.size()){
                ans = temp;
            }

        }

        map.put(key, ans);
        return ans;
    }



    public static void main(String[] args) {
        String[] arr = new String[]{
                "milo",
                "aldez",
                "bella",
                "cooley",
                "blaze",
                "riddle",
                "emilie",
                "zchaefer"



        };
        var map = new HashMap<String, List<String>>();

//System.out.println(solveFull(Arrays.asList(arr),null, new HashMap<String, List<List<String>>>()));
System.out.println(solveMax(Arrays.asList(arr),null, map));



    }
}
/*

                   "milo",
                "aldez",
                "bella",
                "cooley",
                "blaze",
                "riddle",
                "emilie",
                "zchaefer",
                "adelaide",
                "lopez",
                "jackson",
                "giles",
                "pierce",
                "davis",
                "callum",
                "lara",
                "danny",
                "hampton",
                "memphis",
                "evans",
                "gunner",
                "atkinson",
                "darien",
                "francis"

 */
