package Synchorizned.Lesson1;

/**
 * Created by Administrator on 2016/11/14.
 *
 * 当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，
 * 一个时间内只能有一个线程得到执行。
 * 另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块
 */
public class Thread1 implements Runnable{
    @Override
    public  void run() {
        synchronized (this){
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"synchronized loop "+ i);
            }
        }
    }

    /**
     * 运行结果：
     A_threadsynchronized loop 0
     A_threadsynchronized loop 1
     A_threadsynchronized loop 2
     A_threadsynchronized loop 3
     A_threadsynchronized loop 4
     B_threadsynchronized loop 0
     B_threadsynchronized loop 1
     B_threadsynchronized loop 2
     B_threadsynchronized loop 3
     B_threadsynchronized loop 4
     * @param args
     */
    public static void main(String [] args){
         Thread1 thread1=new Thread1();
         Thread ta=new Thread(thread1,"A_thread");
         Thread tb=new Thread(thread1,"B_thread");
         ta.start();
         tb.start();
    }
}
