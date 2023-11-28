package Enum.lesson1;

/**
 * Created by Administrator on 2016/11/15.
 */
public class TestColor {
    //枚举类switch语句里面的使用
    public static void main(String args[]){
        switch (Color.RED){
            case BLUE:
                System.out.println("it is blue");
                break;
            case RED:
                System.out.println("it is red");
                break;
            case GREEN:
                System.out.println("it is green");
        }
    }
}
