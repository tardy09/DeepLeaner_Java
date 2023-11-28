package Thread.lesson1;

/**
 * Created by Administrator on 2016/11/16.
 */
public class SleepInterrupt implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" 在run方法里，--这个线程休眠20秒。。。");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("在run方法里面--中断线程");
            return;
        }
        System.out.println(Thread.currentThread().getName()+" 在run()方法里面休眠之后继续运行");
        System.out.println("正常退出");
    }
    public static void main(String [] args){
        SleepInterrupt si=new SleepInterrupt();
        Thread t=new Thread(si,"si");
        t.start();
        System.out.println("Thread "+Thread.currentThread().getName());
        if(t.isAlive()){
            System.out.println("  wo is running ...");
        }
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){

        }
        System.out.println("在mian方法里中中断其他线程");
        t.interrupt();
        System.out.println("在main里面退出");

    }
}
