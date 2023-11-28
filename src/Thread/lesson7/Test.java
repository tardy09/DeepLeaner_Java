package Thread.lesson7;

/**
 * Created by Administrator on 2016/12/25.
 */
public class Test {
    public static void main(String [] args){
        try {
            Object lock=new Object();
            MyThread1 myThread1=new MyThread1(lock);
            System.out.println(Thread.currentThread().getName()+"开始执行了。。"+Thread.currentThread().getPriority());
            myThread1.start();
            System.out.println(Thread.currentThread().getName()+"开始执行了");
            Thread.sleep(1000);
            MyThread2 myThread2=new MyThread2(lock);
            System.out.println("woshi" +Thread.currentThread().getName());
            myThread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
