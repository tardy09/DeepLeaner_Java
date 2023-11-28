package Thread.lesson1;

/**
 * Created by Administrator on 2016/11/16.
 */
public class ThreadYield {
    public static void main(String args[]){
        yieldClassThread target=new yieldClassThread();
        //其中线程1,2是并发运行
        new Thread(target,"线程1").start();
        System.out.println(Thread.currentThread().getName());
        new Thread(target,"线程2").start();

    }
}
class yieldClassThread implements Runnable{

    public void run(){    // 覆写run()方法
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(2000) ;//休眠一下
            }catch(Exception e){}
            System.out.println(Thread.currentThread().getName()
                    + "运行，i = " + i) ;    // 取得当前线程的名字
            if(i==2){
                System.out.print("线程礼让：") ;
                Thread.currentThread().yield() ;    // 首先获取当前线程，然后线程礼让
            }
        }
    }
}