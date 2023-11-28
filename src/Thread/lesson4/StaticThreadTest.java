package Thread.lesson4;

/**
 * Created by Administrator on 2016/11/17.
 *  因为静态初始化块启动新线程执行初始化操作引发的死锁问题
 *
 *  在StaticThreadTest类里面，为该类定义了一个静态的website,并且为其指定
 *  www.baidu.com;但是程序也在静态初始化块里面将website设置成为www.baidu.com，并且静态
 *  初始化块排在前面，。如果只是保留这样的结构，那么初始化机制再将website的值赋值为www.baidu.com
 *    但是在这个静态的代码块里面不是简单的将website赋值为www.baidu.come而是启动了一条心的线程来执行初始化操作
 *
 *    下面分析执行细节：当某个线程试图访问一个类的静态field时候，根据该类的状态可能出现下面四种情况：
 *      1.该类尚没有被初始化：当前线程开始执行初始化操作
 *      2.该类正在被当前线程执行初始化：这是对当前初始化的递归请求
 *      3.该类正在被其他线程执行初始化：当前线程暂停，等待其他线程初始化完成
 *      4.这个类已经被初始化：直接得到该静态的field值。
 *
 *      main线程试图访问StaticThreadTest的静态属性值时候，这个时候StaticThreadTest尚没有被
 *      初始化，因此main线程开始对该类执行初始化操作，初始化操作主要完成下面两个步骤：
 *        1.为该类所有的静态field分配内存
 *        2.调用静态初始化块的代码执行初始化
 *        因此,main线程首先会为StaticThreadTest的静态属性分配内存，此时website的默认值
 *        为null,接着main线程开始执行StaticThreadTest类的静态初始化块，该代码块创建并且启动了
 *        一条新的线程，并且调用了新的线程的join方法，这就意味着main线程必须等待新的线程的执行结束才能
 *        继续往下面执行。
 *%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 *                               新的线程开始执行之后，首先执行
 *        System.out.println("进入"+Thread.currentThread().getName()+"的run()方法");
 *        这就是运行该程序看到的第一行输出，接着程序视图执行System.out.println(website);问题出现了
 *        StaticThreadTest此时正在由main线程执行初始化操作，因此新的线程会等待main线程对StaticThreadTest
 *        类初始化结束。这个时候就出现了死锁，两个线程相互等待对方执行，因此都不能向下面执行，因此程序执行到这里就出现了
 *        死锁，程序没法向下面执行，这也就是运行该程序时候看到的结果。
 *          //如果把t.join去掉，就可以避免死锁情况 ，这个时候运行的流程如下：
 *          main线程进入SynchronizedStatic的静态初始化块，同样是创建并且启动了新的线程，由于此时并没有调用新的
 *          线程的join方法，因此主线程不会等待新的线程，也就是说，此时新的线程只是出于就绪状态，还没有进入运行状态，
 *          因此不会立即执行run()方法的逻辑
 *          main线程会继续执行初始化代码，它会将website的值初始化为www.baidu.com，至此StaticThreadTest初始化
 *          完成，System.out.println(StaticThreadTest.website);就可以执行，
 *          接下来，新的线程进入可以运行的状态，依次执行run()方法里面的每一行代码，此时访问到的website的值依然
 *          是www.baidu.com
 *          也就是说调用一条线程的start()方法之后，该线程并不会立即进入运行状态，它将保持就绪状态。
 */
public class StaticThreadTest {
    static String website="www.baidu.com";
    static {
        //创建匿名内部类来启动新的线程,并且将属性设置为www.baidu.com
        Thread t=new Thread(){
            @Override
            public void run() {
                System.out.println("进入"+Thread.currentThread().getName()+"的run()方法");
                System.out.println(website);
                website="www.baidu.com";
                System.out.println("退出"+Thread.currentThread().getName()+"的run()方法");
            }
        };
        t.start();
        try {
            t.join();//加入t线程
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        System.out.println(StaticThreadTest.website);
    }
}
