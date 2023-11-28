package Thread.lesson6.demo5;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/2/24.
 *
 * //创建人物的子线程
 * 这个子线程执行实际的子任务，记录执行结果到result变量、异常到exception变量，
 * 执行结束后设置共享状态变量done为true并调用notifyAll以唤醒可能在等待结果的主线程。
 *
 */
public class ExecuteThread<V> extends Thread {
    private V result = null;
    private Exception exception = null;
    private boolean done = false;
    private Callable<V> task;//在Java中，表示子任务的接口是Callable
    private Object lock;

    public ExecuteThread(Callable<V> task, Object lock) {
        this.task = task;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            result = task.call(); //异步返回调用结果
        } catch (Exception e) {
            exception = e;
        } finally {
            synchronized (lock) {
                done = true;
                lock.notifyAll();
            }
        }
    }

    public V getResult() {
        return result;
    }

    public boolean isDone() {
        return done;
    }

    public Exception getException() {
        return exception;
    }

}
