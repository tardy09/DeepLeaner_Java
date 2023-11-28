package Thread.lesson3.demo1;

/**
 * Created by Administrator on 2016/12/21.
 */
public class NumberTest
{
    public static void main(String[] args)
    {
        NumberHolder numberHolder = new NumberHolder();

        Thread t1 = new IncreaseThread(numberHolder);
        Thread t2 = new DecreaseThread(numberHolder);
        Thread t3 = new IncreaseThread(numberHolder);
        Thread t4 = new DecreaseThread(numberHolder);
       //两个线程 产生101010101的效果 四个 就产生混乱
        /**
         *
         */
        t1.start();
        t2.start();
        /**
         * 1
         0
         1  为什么两个线程的时候执行结果正确而四个线程的时候就不对了呢？

         　　因为线程在wait()的时候，接收到其他线程的通知，即往下执行，不再进行判断。两个线程的情况下，唤醒的肯定是另一个线程；但是在多个线程的情况下，执行结果就会混乱无序。

         　　比如，一个可能的情况是，一个增加线程执行的时候，其他三个线程都在wait，这时候第一个线程调用了notify()方法，其他线程都将被唤醒，然后执行各自的增加或减少方法。
         0
         1
         0
         -1
         */
        t3.start();
        t4.start();
    }
}
