package LeetCode;

import java.util.HashMap;

public class LongestSubstr {


        public static int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0) return 0;
            if(s.length() == 1) return 1;

            HashMap<Character, Integer> map = new HashMap<>();

            map.put(s.charAt(0), 0);

            int i = 0;
            int j = 0;

            int max = 1;

            while(  i < s.length() &&j < s.length()){



                Character currI = s.charAt(i);
                Character currJ = s.charAt(j);

                System.out.println("currI = "+currI+" i = " + i +  ", currJ = "+ currJ + " j = "+j + " --- "+map.toString()  + " max = "+ max);

                if(i == j){
                    map.put(currJ,j);
                    j++;
                    continue;
                }



                if(map.containsKey(currJ)){

                    int x = map.get(currJ);
                    while(i <= x && i <j){

                        if(i >s.length() -1){
                            break;
                        }
                        map.remove(s.charAt(i));
                        i++;
                    }


                 //   map.put(currJ, j);




                    continue;
                }




                map.put(currJ, j);


                //(j-i +1);

                max = Math.max(max, j-i+1);

                j++;

            }



            return max;

        }


        public static void main(String[] args){

            System.out.println(lengthOfLongestSubstring("dvdf"));
        }


}
