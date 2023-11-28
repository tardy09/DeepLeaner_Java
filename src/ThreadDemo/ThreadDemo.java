package ThreadDemo;

/**
 * Created by Administrator on 2016/11/16.
 *
 *  //并发线程对资源的竞争
 *  比如售票问题
 *   if(tickets>0) System.out.println(Thread.currentThread().getName()+" 出售票 "+tickets--);
 *   假设tickets的值为1的时候，线程1先执行完if(tickets>0)判断这行代码，正准备执行下面这行代码
 *   就在这个时候，操作系统将CPU切换到了线程2上来执行，此时tickets的值仍然为1，而线程2执行完上面的两行代码，
 *   tickets的值变为0，cpu又切换回到了线程1上面执行，此时线程1不会再去执行判断代码，因为之前已经比较过了
 *   ，并且比较的结果为真，线程1将继续往下面执行，导致产生售票为0的情况。
 *   t3 出售票 19
 t1 出售票 20
 t2 出售票 18
 t4 出售票 17
 t3 出售票 16
 t1 出售票 16
 t2 出售票 15
 t4 出售票 14
 t1 出售票 13
 t3 出售票 12
 t2 出售票 11
 t4 出售票 10
 t1 出售票 9
 t3 出售票 8
 t4 出售票 7
 t2 出售票 6
 t1 出售票 5
 t3 出售票 4
 t2 出售票 3
 t4 出售票 2
 t3 出售票 1
 t1 出售票 1
 t2 出售票 0
 t4 出售票 -1
 从打印结果来看，出现了负数，造成这种原因的根本原因就是因为资源访问不同步引起的
 为了解决这个问题，必须解决下面代码执行的原子性问题
 if(tickets>0) System.out.println(Thread.currentThread().getName()+" 出售票 "+tickets--);
 也就是说当一个线程运行到了if(tickets>0）这行代码的时候，cpu不会切换去执行其他线程中的可能
 影响当前线程中的下一句代码的执行结果的代码块。也就是说必须等到下一句执行完才能去执行其他线程里面的
 有关代码块。这段代码就像时一座独木桥，同一段时间只能有一个人在独木桥上行走，也就是程序里面不允许有多个线程同时
 在这两句代码块执行，这就是线程同步，同步代码块的语法如下l
 synchonized(对象){

 需要同步的代码
 }
 *
 */
public class ThreadDemo{

    //启动四个线程 模拟售票
    public static void main(String [] agrs){
        TestThread testThread=new TestThread();
        Thread t1 =  new Thread(testThread,"t1");
        Thread t2= new Thread(testThread,"t2");
        Thread t3=new Thread(testThread,"t3");
        Thread t4=new Thread(testThread,"t4");
        t1.setPriority(2);
        t2.setPriority(6);
        t3.setPriority(1);
        t4.setPriority(9);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        //打印结果
        /**
         * 4 出售票 20
         t4 出售票 19
         t4 出售票 18
         t4 出售票 17
         t4 出售票 16
         t4 出售票 15
         t4 出售票 14
         t4 出售票 13
         t4 出售票 12
         t4 出售票 11
         t4 出售票 10
         t4 出售票 9
         t4 出售票 8
         t4 出售票 7
         t4 出售票 6
         t4 出售票 5
         t4 出售票 4
         t4 出售票 3
         t4 出售票 2
         t4 出售票 1
         */

    }
}
class TestThread implements Runnable {
    private int tickets=20;
    @Override
    public void run() {
        while (true){
            //加入同步控制，将需要同步控制的代码块放入到synchronized代码块
            /**
             *   形成了同步代码块，在同一个时刻只能有一个线程可以进入同步代码块内执行，
             *   只有当该线程离开了同步代码块后，其他线程才能够进入同步代码块。
             *
             *
             */
            synchronized (this){
                if(tickets>0){
                    try {
                        Thread.sleep(1000);//休眠1秒
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    System.out.println(Thread.currentThread().getName()+" 出售票 "+tickets--);
                }
            }
        }
    }
}
