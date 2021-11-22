public class Ascii {

    public static void main(String args[]){

        char[] alphabets = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

     for(char letter: alphabets){
         Character Letter =letter;
         Character upper = Letter.toString().toUpperCase().toCharArray()[0];
         System.out.println(letter + " " + (int)letter + " " + upper + " "+(int)upper);
     }
    }
}
/*
{
{logcog=[[]],
dotdog=[[log, cog], [cog]],
 loglot=[],
  lotdot=[[dog, log, cog],
  [dog, cog]],
   hotdot=[[dog, log, cog], [dog, cog], [lot, log, dog, cog], [lot, log, cog]],
   doglog=[[cog]],
    dogcog=[[]],
    lotlog=[[dog, cog], [cog]],
    hotlot=[[dot, dog, log, cog], [dot, dog, cog], [log, dog, cog], [log, cog]],
    logdog=[[cog]],
     dotlot=[[log, dog, cog], [log, cog]],
     hithot=[[dot, dog, log, cog], [dot, dog, cog], [dot, lot, log, dog, cog], [dot, lot, log, cog], [lot, dot, dog, log, cog], [lot, dot, dog, cog], [lot, log, dog, cog], [lot, log, cog]]}



 */

