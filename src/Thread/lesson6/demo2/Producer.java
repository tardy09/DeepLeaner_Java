package Thread.lesson6.demo2;

/**
 * Created by Administrator on 2017/2/24.
 *
 * Producer向共享队列中插入模拟的任务数据。一个简单的示例消费者代码如下所示：
 */
public class Producer extends Thread {
    MyBlockingQueue<String> queue;//已经确保是一个线程安全的阻塞队列，生产者线程直接拿来使用

    public Producer(MyBlockingQueue<String> queue,String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
      int num = 0;
        try {
            while (true) {
                String task = String.valueOf(num);
                queue.put(task);
                System.out.println("produce task " + task);
                num++;
                Thread.sleep((int) (Math.random() * 100));//通过休眠  模拟线程在运行任务
            }
        } catch (InterruptedException e) {
        }
    }
}
