package Thread.lesson1;

/**
 * Created by Administrator on 2016/11/16.
 */
public class GetNameThreadDemo extends Thread {
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            printMsg();
        }
    }
    public void printMsg(){
        Thread t=Thread.currentThread();
        System.out.println(t.getName());
    }
    public static void main(String [] args){
        GetNameThreadDemo getNameThreadDemo=new GetNameThreadDemo();
        getNameThreadDemo.start();
        for(int i=0;i<5;i++){
            getNameThreadDemo.printMsg();
        }
    }
}
