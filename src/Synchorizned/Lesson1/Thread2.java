package Synchorizned.Lesson1;

/**
 * Created by Administrator on 2016/11/14.
 *  当一个线程访问object的一个synchronized(this)同步代码块时，
 *  另一个线程仍然可以访问该object中的非synchronized(this)同步代码块
 *
 */
public class Thread2 {
    //同步的
    public void m4t1() {
        synchronized(this) {
            int i = 5;
            while( i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }
    //非同步
    public void m4t2() {
        int i = 5;
        while( i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }
    class Inner {
        private void m4t1() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {
                }
            }
        }
        private void m4t2() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {
                }
            }
        }
    }
    private void m4t1(Inner inner) {
        synchronized (inner) { //使用对象锁
            inner.m4t1();
        }
    }
    private void m4t2(Inner inner) {
        inner.m4t2();
    }
    /**
     * 也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。
     * 结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
     */
    public synchronized void m4t3() {
        int i = 5;
        while( i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }
    /**
     *   运行结果
     *    t1 : 4
     t2 : 4
     t1 : 3
     t2 : 3
     t1 : 2
     t2 : 2
     t1 : 1
     t2 : 1
     t1 : 0
     t2 : 0
     * @param args
     */
    public static void main(String[] args) {
        final Thread2 myt2 = new Thread2();
        Thread t1 = new Thread(  new Runnable() {  public void run() {  myt2.m4t1();  }  }, "t1"  );
        Thread t2 = new Thread(  new Runnable() {  public void run() { myt2.m4t2();   }  }, "t2"  );
        t1.start();
        t2.start();
        final Thread2 myt3 = new Thread2();
        final Inner inner = myt3.new Inner();
        Thread t3 = new Thread( new Runnable() {public void run() { myt3.m4t1(inner);} }, "t3");
        Thread t4 = new Thread( new Runnable() {public void run() { myt3.m4t2(inner);} }, "t4");
        t3.start();
        t4.start();
    }
}
