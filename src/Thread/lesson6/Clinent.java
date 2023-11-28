package Thread.lesson6;

/**
 * Created by Administrator on 2016/12/7.
 */
class Q{
    int n;
    boolean valuseSet=false;
    synchronized int get(){
        if(!valuseSet){
            try {
                wait();//等待生产者生产  ---释放锁
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got:"+n);
        valuseSet=false;
        notify();
        return n;
    }
    synchronized void put(int n){
        if (valuseSet){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.n=n;
        valuseSet=true;
        System.out.println("Put: "+n);
        notify();//唤醒消费者消费  ---恢复相同的对象里面第一个调用wait()的线程
    }
}
class Producer implements Runnable{
    Q q;
    Producer(Q q){
        this.q=q;
        new Thread(this,"producer").start();
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            q.put(i++);
        }
    }
}
class Consumer implements Runnable{
    Q q;
    Consumer(Q q){
        this.q=q;
        new Thread(this,"consumer").start();
    }

    @Override
    public void run() {
        while (true){
            q.get();
        }
    }
}
public class Clinent {
    public static void main(String [] args){
        Q q=new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("press clt+c to stop...");
    }
}
