package Thread.lesson1;

import sun.security.krb5.internal.TGSRep;

/**
 * Created by Administrator on 2016/11/16.
 */
public class ThreadInteraptDemo {
    public static void main(String args[]){
        MynewThread mt = new MynewThread() ;    // 实例化Runnable子类对象
        Thread t = new Thread(mt,"子线程");        // 实例化Thread对象
        t.start() ;    // 启动线程
        try{
            Thread.sleep(2000) ;// 线程休眠2秒
            //System.out.println(Thread.yield());
            //Thread.yield();
            System.out.println(Thread.currentThread().getName()+"线程************");
        }catch(InterruptedException e){
            System.out.println("3、休眠被终止") ;
        }
        t.interrupt() ;    // 中断线程执行

        System.out.println("现在执行的线程："+Thread.currentThread().getName()+"啊哈哈");
    }
}
class MynewThread implements Runnable{    // 实现Runnable接口
    public void run(){    // 覆写run()方法
        System.out.println(Thread.currentThread().getName()+"1、进入run()方法") ;
        try{
            Thread.sleep(10000) ;    // 线程休眠10秒
            System.out.println("2、已经完成了休眠") ;
        }catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName()+"3、休眠被终止") ;
            return ; // 返回调用处 --线程被终止处添加一句话rutrun，表示返回调用处
        }
        System.out.println("4、run()方法正常结束") ;
    }
};