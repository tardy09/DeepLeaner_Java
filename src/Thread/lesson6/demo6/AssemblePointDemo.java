package Thread.lesson6.demo6;

/**
 * Created by Administrator on 2017/2/24.
 * 多个游客线程，各自先独立运行，然后使用该协作对象到达集合点进行同步的示例代码如下：
 */
public class AssemblePointDemo {
    static class Tourist extends Thread {
        AssemblePoint ap;//在线程里关联持有该线程协作对象

        public Tourist(AssemblePoint ap) {
            this.ap = ap;
        }
        @Override
        public void run() {
            try {
                // 模拟先各自独立运行
                Thread.sleep((int) (Math.random() * 1000));

                // 集合
                ap.await();
                System.out.println("arrived");

                // ... 集合后执行其他操作
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        int num = 10;
        Tourist[] threads = new Tourist[num];
        AssemblePoint ap = new AssemblePoint(num);
        for (int i = 0; i < num; i++) {
            threads[i] = new Tourist(ap);
            threads[i].start();
        }
    }
}
