package dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HowConstruct {
public static HashMap<String,ArrayList> h = new HashMap<>();
public static int t = 0;

    public static ArrayList howConstruct(String str, String[] arr, ArrayList<ArrayList<String>> ans,ArrayList<String> track){

if(h.containsKey(str)) return h.get(str);
        t++;
        if(str.equals("")) return ans;

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            String replacement = str.replaceAll(s,"");
            if(str.equals(replacement)){
                continue;
            }
            track.add(s);
                var x = howConstruct(replacement,arr,ans,track);
                if(x != null && replacement.equals("")){
                    ans.add((ArrayList<String>) track.clone());
                }
            h.put(replacement,x);

track.remove(track.size()-1);

        }


return ans;
    }


    public static List<String> howConstructDistantOne(String str, String[] arr, HashMap<String,List<String>> memo){

        if(memo.containsKey(str)) return memo.get(str);
        if(str.equals("")) return new ArrayList<>(){{add("");}};

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            String replacement = str.replaceAll(s,"");
            if(str.equals(replacement) || str.indexOf(s) != 0){
                continue;
            }

                var x = howConstructDistantOne(replacement,arr,memo);
memo.put(replacement,x);
            x = x.stream().map((var a)-> a.equals("") ? s : s +" " + a).collect(Collectors.toList());

            ans.addAll(x);


        }


return ans;
    }



    public static void main (String[] args){



      //  System.out.println(howConstruct("baseball", new String[]{"a","all","b","ball","bas","base","cat","code","d","e","quit","z"}, new ArrayList<>(),new ArrayList<>() ));
        System.out.println(howConstructDistantOne("baseball", new String[]{"a","all","b","ball","bas","base","cat","code","d","e","quit","z"}, new HashMap<>() ));




    }
}

