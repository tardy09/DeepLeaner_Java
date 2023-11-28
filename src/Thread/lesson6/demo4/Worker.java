package Thread.lesson6.demo4;

/**
 * Created by Administrator on 2017/2/24.
 */
public class Worker extends Thread {
    MyLatch latch;

    public Worker(MyLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {

            // simulate working on task
            Thread.sleep((int) (Math.random() * 1000));

            System.out.println(Thread.currentThread().getName()+"耗时 "+(System.currentTimeMillis()));
            this.latch.countDown();//每个线程执行完自己的工作之后 都需要主动的调用countwonLatch
        } catch (InterruptedException e) {
        }
    }
}
