package Thread.lesson6.demo2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2017/2/24.
 *
 * 在生产者/消费者模式中，协作的共享变量是队列，生产者往队列上放数据，如果满了就wait，
 * 而消费者从队列上取数据，如果队列为空也wait。我们将队列作为单独的类进行设计，代码如下：
 *
 * MyBlockingQueue是一个长度有限的队列，长度通过构造方法的参数进行传递，有两个方法put和take。put是给生产者使用的，往队列上放数据，满了就wait，
 * 放完之后调用notifyAll，通知可能的消费者。take是给消费者使用的，从队列中取数据，如果为空就wait，取完之后调用notifyAll，通知可能的生产者
 *
 *
 *
 *
 * 只能有一个条件等待队列，这是Java wait/notify机制的局限性，这使得对于等待条件的分析变得复杂，
 * 后续我们会介绍显式的锁和条件，它可以解决该问题
 */
public class MyBlockingQueue<E> {
    private Queue<E> queue = null;
    private int limit;

    public MyBlockingQueue(int limit) {
        this.limit = limit;
        queue = new ArrayDeque<>(limit);
    }

    public synchronized void put(E e) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }
        queue.add(e);
        notifyAll();//所以要调用notifyAll而不能调用notify，因为notify只能唤醒一个线程，如果唤醒的是同类线程就起不到协调的作用。
    }

    public synchronized E take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        E e = queue.poll();
        notifyAll();//所以要调用notifyAll而不能调用notify，因为notify只能唤醒一个线程，如果唤醒的是同类线程就起不到协调的作用。
        return e;
    }
}
