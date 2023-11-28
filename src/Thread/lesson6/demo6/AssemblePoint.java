package Thread.lesson6.demo6;

/**
 *   所谓线程对象  ----就是多线程通过关联持有该对象来完成线程之间的功能协作和功能调用
 *
 * 协作的共享变量依然是一个数，这个数表示未到集合点的线程个数，初始值为子线程个数，
 * 每个线程到达集合点后将该值减一，如果不为0，表示还有别的线程未到，进行等待，如果变为0，
 * 表示自己是最后一个到的，调用notifyAll唤醒所有线程
 */
public class AssemblePoint {
    private int n;

    public AssemblePoint(int n) {
        this.n = n;
    }
    public synchronized void await() throws InterruptedException {
        if (n > 0) {
            n--;
            System.out.println( Thread.currentThread().getName()+" is arriving ");
            if (n == 0) {
                notifyAll();
            } else {
                while (n != 0) {
                    wait();
                }
            }
        }
    }
}
