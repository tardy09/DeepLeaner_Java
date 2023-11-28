package juc.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/2/24.
 * 基本用法
 AtomicInteger有两个构造方法：
 public AtomicInteger(int initialValue)
 public AtomicInteger()

 第一个构造方法给定了一个初始值，第二个的初始值为0。

 可以直接获取或设置AtomicInteger中的值，方法是：
 public final int get()
 public final void set(int newValue)

 之所以称为原子变量，是因为其包含一些以原子方式实现组合操作的方法，比如：
 //以原子方式获取旧值并设置新值
 public final int getAndSet(int newValue)
 //以原子方式获取旧值并给当前值加1
 public final int getAndIncrement()
 //以原子方式获取旧值并给当前值减1
 public final int getAndDecrement()
 //以原子方式获取旧值并给当前值加delta
 public final int getAndAdd(int delta)
 //以原子方式给当前值加1并获取新值
 public final int incrementAndGet()
 //以原子方式给当前值减1并获取新值
 public final int decrementAndGet()
 //以原子方式给当前值加delta并获取新值
 public final int addAndGet(int delta)

 这些方法的实现都依赖另一个public方法：
 public final boolean compareAndSet(int expect, int update)

 这是一个非常重要的方法，比较并设置，我们以后将简称为CAS。该方法以原子方式实现了如下功能：如果当前值等于expect，
 则更新为update，否则不更新，如果更新成功，返回true，否则返回false。
 AtomicInteger可以在程序中用作一个计数器，多个线程并发更新，也总能实现正确性，我们看个例子：
 */
public class AtomicIntegerDemo {
    private static AtomicInteger counter = new AtomicInteger(0);

    static class Visitor extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                counter.incrementAndGet();
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 100;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Visitor();
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter.get());//1000
    }
}
/**
 * 下面分析基本原理和思维
 *
 *                基本原理和思维
         AtomicInteger的使用方法是简单直接的，它是怎么实现的呢？它的主要内部成员是：
          private volatile int value;
 *      注意，它的声明带有volatile，这是必需的，以保证内存可见性。
 *      它的大部分更新方法实现都类似，我们看一个方法incrementAndGet，其代码为：
 public final int incrementAndGet() {
 for (;;) {
 int current = get();
 int next = current + 1;
 if (compareAndSet(current, next))
 return next;
 }
 }

 代码主体是个死循环，先获取当前值current，计算期望的值next，然后调用CAS方法进行更新，如果当前值没有变
 ，则更新并返回新值，否则继续循环直到更新成功为止。

 与synchronized锁相比，这种原子更新方式代表一种不同的思维方式。

 synchronized是悲观的，它假定更新很可能冲突，所以先获取锁，得到锁后才更新。原子变量的更新逻辑是乐观的，
 它假定冲突比较少，但使用CAS更新，也就是进行冲突检测，如果确实冲突了，那也没关系，继续尝试就好了。

 synchronized代表一种阻塞式算法，得不到锁的时候，进入锁等待队列，等待其他线程唤醒，有上下文切换开销。
 原子变量的更新逻辑是非阻塞式的，更新冲突的时候，它就重试，不会阻塞，不会有上下文切换开销。
 *基于CAS，除了可以实现乐观非阻塞算法，它也可以用来实现悲观阻塞式算法，比如锁，
 * 实际上，Java并发包中的所有阻塞式工具、容器、算法也都是基于CAS的 (不过，也需要一些别的支持)。
 *
 *
 *
 *
 *
 */

