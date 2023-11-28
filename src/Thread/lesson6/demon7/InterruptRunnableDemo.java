package Thread.lesson6.demon7;

/**
 * Created by Administrator on 2017/2/24.
 */
public class InterruptRunnableDemo  extends Thread{
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // ... 单次循环代码
            // Thread.sleep(100000000);//模拟一个长时间任务
            System.out.println(Thread.currentThread().getName()+ "is working .......");
        }
        System.out.println("done.......");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptRunnableDemo();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.exit(0);
    }
}
