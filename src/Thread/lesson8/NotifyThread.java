package Thread.lesson8;

/**
 * Created by Administrator on 2016/12/25.
 */
public class NotifyThread extends Thread{
    private Object lock;
    public NotifyThread(Object lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        Service service=new Service();
        service.syncNotifyMethod(lock);
    }
}
