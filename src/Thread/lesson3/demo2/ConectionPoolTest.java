package Thread.lesson3.demo2;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2016/12/21.
 */
public class ConectionPoolTest {
    static ConnectionPool pool=new ConnectionPool(10);
    //保证所有的ConnectionRunner能够同时开始
    /**
     * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，
     * 直到其他线程的操作执行完后再执行,CountDownLatch这个类能够使一个线程等待其他线程完成各自的工作后再执行。例如，
     * 应用程序的主线程希望在负责启动框架服务的线程已经启动所有的框架服务之后再执行。
     * CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，
     * 计数器的值就会减1。当计数器值到达0时，
     * 它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
     */
    static CountDownLatch start=new CountDownLatch(1);
    //main线程会等待当所有的ConnectionRunner结束后继续运行
    static CountDownLatch end;

    static class ConnectionRunner implements Runnable{
        int count;
        /**
         * 个提供原子操作的Integer的类。在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，
         * 不可避免的会用到synchronized关键字。而AtomicInteger则通过一种线程安全的加减操作接口。
         */
        AtomicInteger got;

        @Override
        public void run() {
            try {
                /**
                 * 与CountDownLatch的第一次交互是主线程等待其他线程。主线程必须在启动其他线程后立即调用
                 * CountDownLatch.await()方法。
                 * 这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
                 */
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count>0){
                try {
                    /**
                     * 从线程池获得连接，如果1000ms内无法取得连接，那么将会返回null
                     * 分别统计连接获取到的数量got和未获取到的数量notgot
                     */
                    Connection connection=pool.fetchConnection(1000);
                    if(connection!=null){
                        connection.createStatement();
                        connection.commit();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
