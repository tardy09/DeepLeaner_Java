package juc.ThreadPool;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface ThreadPool<Job extends Runnable>
{
    void execute(Job job);//执行一个job,这个job需要实现runnable]

    void shutDown();//关闭线程池

    void addWorkers(int num);
    void removeWoker(int num);
    int getJobSize();//获得正在等待执行的任务的数量
}
