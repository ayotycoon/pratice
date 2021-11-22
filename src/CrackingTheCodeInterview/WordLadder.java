package CrackingTheCodeInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WordLadder {


static int diff(String s1, String s2){

    int x = 0;



    for (int i = 0; i < s1.length(); i++) {

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(i);

        if(c1 != c2){
            x++;
        }

    }
    return x;


}


   static List<String> solve (String beginWord, String endWord, String[] dict, HashMap<String,Boolean> map ) {
       if(beginWord.equals(endWord)){
          ArrayList<String> x =  new ArrayList<>();
          x.add("");
           return x;
       }
       if(map.size() == dict.length) return null;

       List<String> ans = new ArrayList<>();

       for (int i = 0; i < dict.length; i++) {

           var curr = dict[i];
           if(diff(curr, beginWord) != 1 || map.containsKey(curr)) continue;

           map.put(curr,true);
           List<String> temp = solve(curr, endWord,dict,map);
           if(temp != null){
               temp = temp.stream().map((var a)-> curr+(!a.equals("") ? "->"+a : "")).collect(Collectors.toList());
               ans.addAll(temp);

           }

       }
   return ans;

    }


   static List<ArrayList<String>> solveAll (String beginWord, String endWord, String[] dict, HashMap<String,Boolean> map ) {
       if(beginWord.equals(endWord)){
          List<ArrayList<String>> y =  new ArrayList<>();
          ArrayList<String> x =  new ArrayList<>();

          x.add("");
          y.add(x);
           return y;
       }
       if(map.size() == dict.length) return null;

       List<ArrayList<String>> ans = new ArrayList<>();

       for (int i = 0; i < dict.length; i++) {

           var curr = dict[i];
           if(diff(curr, beginWord) != 1 || map.containsKey(curr)) continue;

           map.put(curr,true);
           List<ArrayList<String>> temp = solveAll(curr, endWord,dict,map);
           if(temp != null){
               temp = temp.stream().map((var b)-> (ArrayList<String>) b.stream().map((var a)->  curr+(!a.equals("") ? "->"+a : "")).collect(Collectors.toList())).collect(Collectors.toList());
               ans.addAll(temp);

           }

       }
   return ans;

    }

   static Integer solveAllMin (String beginWord, String endWord, String[] dict, HashMap<String,Boolean> map ) {
       if(beginWord.equals(endWord)){

           return 0;
       }
       if(map.size() == dict.length) return null;

       Integer ans = 99;

       for (int i = 0; i < dict.length; i++) {

           var curr = dict[i];
           if(diff(curr, beginWord) != 1 || map.containsKey(curr)) continue;

           map.put(curr,true);
           Integer temp = solveAllMin(curr, endWord,dict,map) + 1;
           if(temp != null){
               ans=Math.min(ans,temp);

           }

       }
   return ans;

    }

    public static void main (String[] args){
      String beginWord = "hit";
      String endWord = "cog";
      String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
       // System.out.println(solve(beginWord,endWord,wordList, new HashMap<String,Boolean>()));
       // System.out.println(solveAll(beginWord,endWord,wordList, new HashMap<String,Boolean>()));
        System.out.println(solveAllMin(beginWord,endWord,wordList, new HashMap<String,Boolean>()));

    }

}
