package CheatSheet.Twitter;

public class WeirdFaculty {


    public static void main (String[] args){
        int k = 0;
        int me = 0;
        int friend = 0;
        int[] arr = {0,1,1,0,0,1,1,0};
        for(int a : arr) friend+=(a == 1 ? 1 : -1);

        for(int x : arr) {
            int a = (x == 1 ? 1 : -1);
            int p1 = me +a;
            int p2 = friend - a;
            me = p1;
            friend = p2;
            if(p1 <= p2){
                k++;
            }else {
                break;
            }
        }

        System.out.println("k= " + k +" me= " + me + " friend= " + friend);


    }


}
