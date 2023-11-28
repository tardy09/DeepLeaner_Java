package Thread.lesson3;

import java.security.PublicKey;

/**
 *
 * Created by Administrator on 2016/11/16.
 *
 */
class Person{
    //定义modle作为新的数据结构作为数据存储空间
    private   String name;
    private String sex;
    //定义存储空间状态标识位，
    /**
     *   当Coesumer取走数据后，bFull的值为false,
     *   当Producer线程放入数据后，bFull值为true
     *   只有bFull为true的时候，consumer线程才能够取走数据，
     *   否则就等待Producer线程放入新的数据后的通知，；
     *   反之，只有bFull为false,Producer线程才能进入新的数据
     *   ，否则就必须等待Consumer线程取走数据后的通知。
     */
    boolean bFull=false;
    //定义同步方法，避免生产者和消费者线程对同一资源的访问的同步
    public synchronized void set(String name,String sex){
        if(bFull){
            try {
                wait();  //后来的线程要等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       // this.sex=sex;
        this.name=name;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.sex=sex;
        bFull=false;
        notify();//唤醒最先到达的线程
    }

    public synchronized void get(){
        if(!bFull){
            try {
                wait();//只有bFull为true时候才可以取走数据
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        System.out.println(this.name+"--->"+this.sex);
        bFull=false;//取走数据后置为false
        notify();
    }
}
class Produces implements Runnable{
    Person p=null;

    public Produces(Person p) {
        this.p = p;
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            if(i==0){
              p.set("张丹峰","男");
            }
            else {
                p.set("孟烨","女");
            }
            i=(i+1)%2;
        }
    }
}
class Consumer implements Runnable{
    Person p=null;
    public Consumer(Person p){
        this.p=p;
    }
    @Override
    public void run() {

        while (true){
            p.get();
        }
    }
}
public class ThreadCommunication {
     public static void main(String agrs[]){
         Person person=new Person();
         new Thread(new Produces(person)).start();
         new Thread(new Consumer(person)).start();
     }
}
