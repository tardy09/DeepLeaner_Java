package Thread.lesson8;

/**
 * Created by Administrator on 2016/12/25.
 */
public class ThreadA extends Thread {
    private Object lock;
    public ThreadA(Object lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        Service service=new Service();
        service.testMethod(lock);
    }
}
