package juc.ReentrantLock;

/**
 * Created by Administrator on 2017/2/24.
 */
public class Task extends Thread {
    private Counter counter;
    public Task(String name,Counter C) {
        super(name);
        this.counter=C;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++) {
            counter.incr();
        }

    }
}
