package Thread.lesson6.demo3.基于wait;

/**
 * Created by Administrator on 2017/2/24.
 */
public class Clinet {
    public static void main(String []args){
        int num = 10;
        FireFlag fireFlag = new FireFlag();
        Thread[] racers = new Thread[num];
        for (int i = 0; i < num; i++) {
            racers[i] = new Racer(fireFlag);
            racers[i].start();
        }
        try {
            Thread.sleep(1000);//等待其他所有的线程都启动完毕之后
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fireFlag.fire();
    }
}
