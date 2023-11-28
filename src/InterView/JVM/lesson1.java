package InterView.JVM;

/**
 * Created by Administrator on 2017/3/4.
 */
public class lesson1 {
    public static void main(String [] args){

        for (int i = 0; i < 10; i++) {
                  new Person("STR"+i,5*i);
        }
        System.out.println("******");
    }
}
