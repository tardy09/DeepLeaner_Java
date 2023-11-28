package Thread.lesson1;

/**
 * Created by Administrator on 2016/11/15.
 */
public class ThreadDemo_1 {
    public static void main(String[] args){
        new TestThread().run();
        //可以看到下面的代码会被阻塞，直到上面run方法里面的循环代码运行结束时开始运行。
        for(int i=0;i<10;i++){
            System.out.println("main thread is running .....");
            Thread thread;
        }
    }
}
class TestThread{
    public void  run(){
        for(int i=0;i<10;i++){
            System.out.println("TestThread is running....");
        }
    }

}