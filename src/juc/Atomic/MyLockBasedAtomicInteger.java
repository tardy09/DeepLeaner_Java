package juc.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/2/24.
 *
 * 用AtomicInteger实现一个锁MyLock
 * 在MyLock中，使用status表示锁的状态，0表示未锁定，1表示锁定，lock()/unlock()使用CAS方法更新，
 * lock()只有在更新成功后才退出，实现了阻塞的效果，
 * 不过一般而言，这种阻塞方式过于消耗CPU，有更为高效的方式，我们后续章节介绍。
 * MyLock只是用于演示基本概念，实际开发中应该使用Java并发包中的类如ReentrantLock
 *
 *  当需要同步操作的情况下，只需要将需要同步进行操作的代码置于lock和ulock之间
 *
 */
public class MyLockBasedAtomicInteger {
    private AtomicInteger status = new AtomicInteger(0);

    public void lock() {
        while (!status.compareAndSet(0, 1)) {
            Thread.yield();//暂停当前的线程  只有当当前的status处于未锁定的状态，才可以进行更新操作 加锁
        }
    }

    public void unlock() {
        status.compareAndSet(1, 0);
    }
}
