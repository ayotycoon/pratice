package dynamic;

import java.util.HashMap;

public class CanConstruct2 {

public static int t = 0;

    public static int canConstruct(String str, String[] arr, HashMap<String,Integer> memo){
// "purple", new String[]{"purp","p","ur","le","purpl"}
if(memo.containsKey(str)) return memo.get(str);
        t++;
        if(str.equals("")) return 1;
int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            if(str.indexOf(s) != 0){
                continue;
            }


            String replacement = str.replace(s,"");

var x = canConstruct(replacement,arr,memo) ;
            ans+=x;

            memo.put(replacement,x);

        }


return ans;
    }



    public static void main (String[] args){



        System.out.println(canConstruct("purple", new String[]{"purp","p","ur","le","purpl"}, new HashMap<>()));



    }
}

