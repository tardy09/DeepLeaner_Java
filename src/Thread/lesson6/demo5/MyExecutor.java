package Thread.lesson6.demo5;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/2/24.
 */
public class MyExecutor {
    /**
     * 利用该方法，对于主线程，它就不需要创建并管理子线程了，并且可以方便地获取异步调用的结果，比如，在主线程中，可以类似这样启动异步调用并获取结果：
     * @param <V>
     * @param task
     * @return
     *
     * MyExecutor的execute方法是怎么实现的呢？它封装了创建子线程，同步获取结果的过程
     *
     * MyFuturetoe相当于一个总的调度师 来完成多个异步任务的分发和结果的获取
     *
     *
     * */

    public <V> MyFuture execute(final Callable<V> task){
        final Object lock = new Object();
        final ExecuteThread<V> thread = new ExecuteThread<>(task, lock);//创建任务获取结果的子线程
        thread.start();

        MyFuture<V> future = new MyFuture<V>() {
            @Override
            public V get() throws Exception {
                synchronized (lock) {
                    while (!thread.isDone()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    if (thread.getException() != null) {
                        throw thread.getException();
                    }
                    return thread.getResult();
                }
            }
        };
        return future;
    }
}
