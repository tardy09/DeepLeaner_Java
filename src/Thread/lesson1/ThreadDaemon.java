package Thread.lesson1;

/**
 * Created by Administrator on 2016/11/16.
 */
public class ThreadDaemon  {
    public static void main(String [] args){
        ThreadTest T1=new ThreadTest();
        Thread thread=new Thread(T1);
        thread.setDaemon(true);
        thread.start();
    }
}
class ThreadTest implements Runnable{
    @Override
    public void run() {
        //从运行结果看，虽然是个死循环，但是因为他是后台线程，
        // 因此整个进程在主程序结束时候就随之终止运行了。
        while (true){
            System.out.println(Thread.currentThread().getName()+"is running");
        }
    }
}
