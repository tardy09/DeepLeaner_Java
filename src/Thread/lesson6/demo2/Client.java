package Thread.lesson6.demo2;

/**
 * Created by Administrator on 2017/2/24.
 */
public class Client {
    public static void main(String []args){
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(3);
        //两个生产者
        for (int i=0;i<3;i++) {
            new Producer(queue,"producer").start();
        }
        for (int j=0;j<2;j++) {
            new Consumer(queue).start();
        }
    }

}
