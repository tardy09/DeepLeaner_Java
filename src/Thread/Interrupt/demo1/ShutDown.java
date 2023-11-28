package Thread.Interrupt.demo1;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/21.
 */
public class ShutDown {

    /**
     * 输出Count i= 13303812
     Count i= 16970790
     * @param args
     *
     * 下面的程序中 main线程通过中断操作和cancel()方法均可以
     * 使得countThread得以中止。通过这种标识位或者中断的方式能够使得线程
     * 在中止的时候有机会去清理资源，
     */
    public static void main(String [] args){
        Runner one=new Runner();
        Thread countThread=new Thread(one,"countThread");
        countThread.start();
        try {
            //休眠一秒 让main线程对count Thread线程进行中断，使得countThread能够感知中断而停止
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countThread.interrupt();
        Runner two=new Runner();
        countThread=new Thread(two,"countThread");
        countThread.start();
        try {
            //休眠一秒 让main线程对Thread two线程进行取消，使得countThread能够感知on为false而停止
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        two.cancel();
    }
    private static class Runner implements Runnable{
        private long i;
        private volatile  boolean on=true;
        @Override
        public void run() {
            while (on&&!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i= "+i);
        }
        public void  cancel(){
            on=false;
        }
    }
}
