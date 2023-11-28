package Thread.lesson6.demo4;

/**
 * Created by Administrator on 2017/2/24.
 */
public class Client {
    public static void main(String [] args){
        int workerNum = 10;
        MyLatch latch = new MyLatch(workerNum);
        Worker[] workers = new Worker[workerNum];
        for (int i = 0; i < workerNum; i++) {
            workers[i] = new Worker(latch);
            workers[i].start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("collect worker results");
        System.exit(0);
    }
}
