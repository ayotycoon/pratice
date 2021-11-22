package LeetCode;

public class MyAtoi {


        public static int myAtoi(String s) {
            if(s == null) return 0;
            Boolean isPositive = true;

            StringBuilder builder = new StringBuilder();


            for(int i=0; i< s.length(); i++){
                Character c = s.charAt(i);

                if(c == ' ') continue;
                if(c == '+') {
                    isPositive = true;
                    continue;
                }
                if(c == '-') {
                    isPositive = false;
                    continue;
                }

                try{
                    Integer num = Integer.parseInt(String.valueOf(c));
                    builder.append(num);
                }catch(Exception e){
                    break;
                }

            }
            String stringTotal = builder.toString();

            if(stringTotal.equals("")){
                return 0;
            }
            System.out.println(stringTotal);


            try{
                Integer total = Integer.parseInt(stringTotal) * (isPositive ? 1 : -1);

                return total;
            }catch (Exception e){
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }


            //   Integer.MAX_VALUE
//String.va
        }

        public static void main(String[] args){
            System.out.println("Ans - " +myAtoi("+-12"));
        }

}
