package Thread.lesson3.demo2;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by Administrator on 2016/12/21.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool =new LinkedList();
    public ConnectionPool(int initiSize){
        for (int i = 0; i <initiSize ; i++) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }
    public void  releaseConection(Connection co){
        if(co!=null){
            synchronized (pool){
                //连接释放之后需要进行通知，这样其他消费者可以
                //感知到连接池里面已经归还了一个连接
                pool.addLast(co);
                pool.notifyAll();
            }
        }
    }
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            //完全超时  --直接返回
            if(mills<=0){
                while (pool.isEmpty()){
                        pool.wait();
                }
                //直到生成者生产下connection后立即返回
                return pool.removeFirst();
            }else {
                //没有超时的情况下--继续等待 返回
                long future=System.currentTimeMillis();
                long remain=mills;
                while (pool.isEmpty()&&remain>0){
                    pool.wait(remain);
                    remain=future-System.currentTimeMillis();
                }
                Connection result=null;
                if(!pool.isEmpty()){
                    result=pool.removeFirst();
                }
                return result;
            }
        }
    }
}
