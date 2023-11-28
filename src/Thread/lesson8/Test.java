package Thread.lesson8;

/**
 * Created by Administrator on 2016/12/25.
 */
public class Test {
    /**
     *  这个实验表明 必须执行完notify（）方法所在的同步代码块后
     *  才能释放锁
     *  begin wait() threadName= Thread-0 time=1482654932220
     begin notify() ThreadName=Thread-1 time=1482654932220
     end notify() ThreadName=Thread-1 time=1482654937227
     end wait() threadName= Thread-0 time=1482654937227
     begin notify() ThreadName=Thread-2 time=1482654937227
     end notify() ThreadName=Thread-2 time=1482654942235

     * @param args
     */
 public static void main(String [] args){
     Object lock=new Object();
     ThreadA threadA=new ThreadA(lock);
     threadA.start();
     NotifyThread notifyThread=new NotifyThread(lock);
     notifyThread.start();
     synNotifyMethodThread synNotifyMethodThread=new synNotifyMethodThread(lock);
     synNotifyMethodThread.start();

 }
}
