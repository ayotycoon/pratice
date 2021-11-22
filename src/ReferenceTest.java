 class Obj{
    public Integer num;
    public Obj(Integer num){
        this.num = num;
    }

     @Override
     public String toString() {
         return "Obj{" +
                 "num=" + num +
                 '}';
     }
 }

public class ReferenceTest {
    public static void main(String args[]){
        var first = new Obj(5);

        var first1 = first;

        System.out.println(first);
        System.out.println(first1);
        first1.num = 10;

        System.out.println(first);
        System.out.println(first1);
    }

}
