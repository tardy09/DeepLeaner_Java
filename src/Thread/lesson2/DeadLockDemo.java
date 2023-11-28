package Thread.lesson2;

/**
 * Created by Administrator on 2016/11/16.
 */
class A{
    synchronized void funA(B b) {
        System.out.println(Thread.currentThread().getName()+"进入 A.too");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName()+"调用 B类的last方法");
        b.last();
    }
    synchronized void last(){
        System.out.println("A 类里面的last()方法");

    }
}
class B{
 synchronized void funB(A a){
     System.out.println(Thread.currentThread().getName()+"进入 B 类里面");
     try {
         Thread.sleep(1000);
     } catch (InterruptedException e) {
         System.out.println(e.getMessage());
     }
     System.out.println(Thread.currentThread().getName()+" 调用A类里面的last方法 ");
     a.last();
 }
 synchronized void  last(){
     System.out.println("B类里面的last方法");
 }

}
public class DeadLockDemo implements Runnable {
    A a=new A();
    B b=new B();
    DeadLockDemo(){
        //设置当前线程的名称
       // Thread.currentThread().setName("Main--> Thread");
        new Thread(this).start();
        a.funA(b);
        System.out.println(Thread.currentThread().getName()+"main 线程运行完毕");
    }

    @Override
    public void run() {
        //Thread.currentThread().setName("Test-->thread");
        b.funB(a);
        System.out.println("其他线程运行完毕");
    }

    /**
     * main进入 A.too
     Thread-0进入 B 类里面
     main调用 B类的last方法
     Thread-0 调用A类里面的last方法
     从运行结果看，main进入了a的监视器 ，等待b的释放
     而thread 0进入b的监视器 等待a的释放，这个程序永远不会完成
     * @param args
     */
    public static void main(String [] args){
        new DeadLockDemo();
    }
}
