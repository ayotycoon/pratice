package youtube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class PermutationsOfString {
    static Integer track = 0;

    static ArrayList<String> solve(String s, String permute, HashMap<String,ArrayList<String>> memo) {
       if(memo.containsKey(s)){
           return memo.get(s);
       }

        track++;
        if (s.equals("")) {
            var v = new ArrayList<String>();
            v.add("");
            return v;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < permute.length(); i++) {
            Character curr = permute.charAt(i);

           var replacement = s.replace(curr + "", "");

           if(replacement.equals(s)){
               continue;
           }

            var x = solve(replacement, permute, memo);
           memo.put(replacement, x);


            var added = x.stream().map((String a) -> {
                a += curr;
                return a;
            }).collect(Collectors.toList());

            ans.addAll(added);
        }


        return ans;


    }

    public static void main(String[] args) {
        String s = "abcd";


        System.out.println(solve(s, s,new HashMap<>()));

        System.out.println(track);
    }
}
