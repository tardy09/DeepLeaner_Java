package juc.ThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2017/3/1.
 */
public class DefalutThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //线程池最大限制数目
    private static  final  int MAX_WOKER_NMBBERS=10;
    //线程池默认的线程的数目
    private static  final int DEFAULT_WOKER_NMUMBERS=5;
    //线程池最小的数量
    private static final  int MIN_WORKER_NUMBERS=1;
    //这是一个工作列表，将会向里面插入工作
    private final LinkedList<Job> jobs=new LinkedList<>();
    //工作者列表
    private final List<Worker> workers= Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程的数目
    private int wokerNum=DEFAULT_WOKER_NMUMBERS;
    //线程编号
    private AtomicLong threadNUm=new AtomicLong();
    public DefalutThreadPool(int num){
        wokerNum=num>MAX_WOKER_NMBBERS?MAX_WOKER_NMBBERS:num<MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num;
    }

    public DefalutThreadPool() {
        initialIzeWokers(DEFAULT_WOKER_NMUMBERS);
    }

    @Override
    public void execute(Job job) {
        if(job!=null){
            //添加一个工作 然后进行通知
            synchronized (jobs){
                jobs.add(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutDown() {
        for(Worker worker:workers){
            worker.shutDown();
        }
    }

    @Override
    public void addWorkers(int num) {
       synchronized (jobs){
           //现在新增的woker的数量不能超过最大值
           if(num+this.wokerNum>MAX_WOKER_NMBBERS){
               num=MAX_WOKER_NMBBERS-this.wokerNum;
           }
           initialIzeWokers(num);
           this.wokerNum+=num;
       }
    }
    //初始化线程工作者
    private void initialIzeWokers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker=new Worker();
            workers.add(worker);
            Thread thread=new Thread(worker,"ThreadPool worker-"+threadNUm.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void removeWoker(int num) {
        synchronized (jobs){
            if(num>=this.wokerNum){
                throw new IllegalArgumentException("beyond woker num");
            }
            int count=0;
            //按照指定的数量来停止woker
            while (count<num){
                Worker worker=workers.get(count);
                if(workers.remove(worker)){
                    worker.shutDown();
                    count++;
                }
            }
            this.wokerNum-=num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
    //工作者负责消费线程
    class Worker implements   Runnable{
        //是否工作
            private volatile boolean running=true;

        @Override
        public void run() {
            while (running) {
                Job job=null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            //感知到外部的中断操作后进行返回
                            return;
                        }
                    }
                    //取出一个job
                    job=jobs.removeFirst();
                }
                if(job!=null){
                    try {
                        job.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        public void shutDown(){
            running=false;
        }
    }
}
