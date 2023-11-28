package Synchorizned.Lesson1;

/**
 * Created by Administrator on 2016/11/14.
 */
public class TextThread {
    public static void main(String[] args) {
        TxtThread tt = new TxtThread();
        new Thread(tt,"t2").start();
        new Thread(tt,"t1").start();

        new Thread(tt,"t3").start();
        new Thread(tt,"t4").start();
    }
}

class TxtThread implements Runnable {
    int num = 10;
    String str = "hhdhd";

    public void run() {
        synchronized (str) {
            while (num > 0) {

                try {
                  //  Thread.sleep(10);
                } catch (Exception e) {
                    e.getMessage();
                }
                System.out.println(Thread.currentThread().getName()
                        + "   this is " + num--);
            }
            //str=null;
        }
    }
}
