package Thread.lesson5;

/**
 * Created by Administrator on 2016/11/18.
 *
 *    运行结果：
 *    main在运行 哈哈  ....0
      Thread-0 在运行 在run方法里
      main在运行 哈哈  ....1
      Thread-0 在运行 在run方法里
      main在运行 哈哈  ....2
      Thread-0 在运行 在run方法里
      main在运行 哈哈  ....3
      Thread-0 在运行 在run方法里
      main在运行 哈哈  ....4
      Thread-0 在运行 在run方法里
      main 在普通方法里运行
      Thread-0 在运行 在run方法里
      main在运行 哈哈  ....5
      main在运行 哈哈  ....6
      main在运行 哈哈  ....7
      main在运行 哈哈  ....8
      main在运行 哈哈  ....9

 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 分析;本程序定义了一个计数器i,用来控制线程的循环打印的次数，在i的值从0到4的这段时间内，两个线程是交替运行的，当计数器i的值变成5的时候
 程序调用了testThread类的stopMe方法，而在stopMe方法里面，将bFlag变量赋值为false,也就是终止了while循环，run方法结束运行，thread_0随之运行
 终止，（main 在普通方法里运行，Thread-0 在运行 在run方法里）可以看出，在main线程调用了thread的stopMe()方法后，cpu不一定马上切换到thread_0线程，

 *
 *
 */
public class ThreadLife {
    public static void main(String [] args){
        TestThread t=new TestThread();
        new Thread(t).start();
        for(int i=0;i<10;i++){
            if(i==5){
                t.stopMe();
            }
            System.out.println(Thread.currentThread().getName()+"在运行 哈哈  ...." +i);
        }
    }

}
class TestThread implements Runnable{

    private boolean bFag=true;
    public void stopMe() {
        System.out.println(Thread.currentThread().getName()+" 在普通方法里运行");
        bFag = false;
    }
    public void run() {
        while (bFag){
            System.out.println(Thread.currentThread().getName()+" 在运行 在run方法里");
        }
    }
}
