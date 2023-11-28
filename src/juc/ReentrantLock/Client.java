package juc.ReentrantLock;

/**
 * Created by Administrator on 2017/2/24.
 */
public class Client {

    public static void main(String [] args) throws InterruptedException {
        Counter counter=new Counter();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Task("sub "+i,counter);
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(counter.getCount());
        System.exit(0);
    }
}
