package Thread.lesson6.demo2;

/**
 * Created by Administrator on 2017/2/24.
 *
 * Producer向共享队列中插入模拟的任务数据。一个简单的示例消费者代码如下所示：
 */
public class Consumer extends Thread {
    MyBlockingQueue<String> queue;

    public Consumer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (true) {
                String task = queue.take();
                System.out.println("handle task " + task);
                Thread.sleep((int)(Math.random()*100));
            }
        } catch (InterruptedException e) {
        }
    }
}
