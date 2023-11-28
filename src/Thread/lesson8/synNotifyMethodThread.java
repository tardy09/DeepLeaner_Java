package Thread.lesson8;

/**
 * Created by Administrator on 2016/12/25.
 */
public class synNotifyMethodThread extends Thread {
    private Object lock;
    public synNotifyMethodThread(Object lock){
      //  super();
        this.lock=lock;
    }
    @Override
    public void run() {
        Service service=new Service();
        service.syncNotifyMethod(lock);
    }
}
