package dynamic;

import java.util.HashMap;

public class CanConstruct {
public static HashMap<String,Boolean> h = new HashMap<>();
public static int t = 0;

    public static Boolean canConstruct(String str, String[] arr){

if(h.containsKey(str)) return h.get(str);
        t++;
        if(str.equals("")) return true;

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            String replacement = str.replaceAll(s,"");
            if(str.equals(replacement)){
                continue;
            }
var x = canConstruct(replacement,arr);
            h.put(replacement,x);
             if(x) return true;
        }


return false;
    }


    public static Boolean canConstructItr(String str, String[] arr){


        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            String replacement = str.replaceAll(s,"");;
            if(str.equals(replacement)){
                continue;
            }
int j = 1;
           while (i+j <arr.length){
               if(replacement.equals("")) return true;
            int x = replacement.length();
               replacement = replacement.replaceAll(arr[i+j],"");
               if(replacement.length() ==x){
                   break;
               }
           }
        }


        return false;
    }


    public static void main (String[] args){



        System.out.println(canConstruct("enterapotentpot", new String[]{"a","p","ent","enter","ot","o","t"}));
        System.out.println(t);
        System.out.println(canConstructItr("enterapotentpot", new String[]{"a","p","ent","enter","ot","o","t"}));



    }
}

