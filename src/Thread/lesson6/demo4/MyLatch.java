package Thread.lesson6.demo4;

/**
 * Created by Administrator on 2017/2/24.
 *
 * 这里，MyLatch构造方法的参数count应初始化为子线程的个数，
 * 主线程应该调用await()，而子线程在执行完后应该调用countDown()。

 */
public class MyLatch {
    private int count;

    public MyLatch(int count) {
        this.count = count;
    }
    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait();
        }
    }
    public synchronized void countDown() {
        count--;
        if (count <= 0) {
            notifyAll();
        }
    }
}
