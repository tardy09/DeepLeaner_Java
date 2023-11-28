package Thread.lesson6.demo3.基于wait;

/**
 * Created by Administrator on 2017/2/24.
 *
 * 同时开始
 同时开始，类似于运动员比赛，在听到比赛开始枪响后同时开始，下面，我们模拟下这个过程，这里，有一个主线程和N个子线程，
 每个子线程模拟一个运动员，主线程模拟裁判，它们协作的共享变量是一个开始信号。我们用一个类FireFlag来表示这个协作对象，代码如下所示
 */
public class FireFlag {
    private volatile boolean fired = false;

    /**
     * 让没有一个持有fireFlag的子线程在启动之后调用子waitForFire()等待枪响，
     * 而主线程应该调用fire()发射比赛开始信号。
     * @throws InterruptedException
     */
    public synchronized void waitForFire() throws InterruptedException {
        while (!fired) {
            wait();
        }
    }

    public synchronized void fire() {
        this.fired = true;
        notifyAll();//通知所有的线程停止等待
    }
}
