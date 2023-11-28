package juc.ThreadPool;

/**
 * Created by Administrator on 2017/3/1.
 */
public class Test {

   public  static void main(String [] args) throws InterruptedException {
      // Thread.sleep(20000);
       ThreadPool threadPool=new DefalutThreadPool();

              boolean  flag=true;
       threadPool.addWorkers(10);
       while (flag) {
           threadPool.execute(new Runnable() {
               @Override
               public void run() {
                   System.out.println("sjsjsjsjsjsjsjsjsjsjsjsjsjsjsjsj");
               }
           });
       }
       flag=false;
   }

}
