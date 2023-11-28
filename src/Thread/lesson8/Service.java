package Thread.lesson8;

/**
 * Created by Administrator on 2016/12/25.
 */
public class Service {
    public void testMethod(Object lock){
        try {
            synchronized (lock) {
                System.out.println("begin wait() threadName= "
                        +Thread.currentThread().getName()+" time="+System.currentTimeMillis());
                lock.wait();
                System.out.println("end wait() threadName= "+Thread.currentThread().getName()
                        +" time="+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void  syncNotifyMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("begin notify() ThreadName="+Thread.currentThread().getName()+" time="+
                        System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("end notify() ThreadName="+Thread.currentThread().getName()+" time="+
                        System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
