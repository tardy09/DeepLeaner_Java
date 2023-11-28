package Thread.lesson6.demo3.基于wait;

/**
 * Created by Administrator on 2017/2/24.
 *
 * 这里，启动了10个子线程，每个子线程启动后等待fire信号，
 * 主线程调用fire()后各个子线程才开始执行后续操作。
 */
public class Racer extends Thread {
    FireFlag fireFlag;

    public Racer(FireFlag fireFlag) {
        this.fireFlag = fireFlag;
    }

    @Override
    public void run() {
        try {
            this.fireFlag.waitForFire();//每个子线程在启动之后 调用waitFire方法来等待主线程
            System.out.println("start run "
                    + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+"我要开始跑步了  ，哈哈哈哈");
        } catch (InterruptedException e) {
        }
    }
}
