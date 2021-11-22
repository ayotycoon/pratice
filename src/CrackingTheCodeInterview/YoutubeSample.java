package CrackingTheCodeInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class YoutubeSample {



    static ArrayList<String> solve(String main, String[] options){
        if(main.equals("")){
            return new ArrayList<String>();
        }

        for (int i = 0; i < options.length; i++) {
            String curr = options[i];
            String replacement = main.replace(curr,"");
            if(replacement.equals(main))continue;

            var res = solve(replacement, options);
            if(res != null){
                res.add(curr);

                return res;
            }

        }

        return null;
    }




    static int solveTweaked(String main, String[] options){
        if(main.equals("")){
            return 0;
        }

        int min = 99999999;
        for (int i = 0; i < options.length; i++) {
            String curr = options[i];
            String replacement = main.replace(curr,"");
            if(replacement.equals(main))continue;

            var res = solveTweaked(replacement, options) + 1;
          //  System.out.println(res);

                min = Math.min(min, res);




        }

        return min;
    }

    public static void main(String[] args){
       // String a = "3141592653589793238462643383279";
        //String[] b = new String[]{"314","49","9001", "15926535897","14","9323","8462643383279","4","793"};
        String a = "helloworld";
        String[] b = new String[]{"hel","lo","world", "hello","h","helloworld"};
      // Arrays.sor((String l, String m)-> l.length() > m.length());

        System.out.println(solve(a,b));
       System.out.println(solveTweaked(a,b)-1);
    }
}
