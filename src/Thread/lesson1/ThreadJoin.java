package Thread.lesson1;

/**
 * Created by Administrator on 2016/11/16.
 */
public class ThreadJoin {

    public static void main(String [] args){
        ThreadTet threadTet=new ThreadTet();
        Thread pop=new Thread(threadTet);
        pop.start();
        int i=0;
        for(int x=0;x<10;x++){
            if(i==5)
            {
                try {
                    //线程强制运行：join()
        //可以通过join()方法使得一个线程强制运行
                    // ，线程强制运行期间，其他线程无法运行，必须等待此线程完成之后，才可以继续运行
                    pop.join();//强制运行完该线程，
                    /**
                     * 程序运行结果：
                     * main Thread -->0
                     Thread-0----> 0
                     main Thread -->1
                     Thread-0----> 1
                     main Thread -->2
                     Thread-0----> 2
                     main Thread -->3
                     Thread-0----> 3
                     main Thread -->4
                     Thread-0----> 4
                     Thread-0----> 5
                     Thread-0----> 6
                     Thread-0----> 7
                     Thread-0----> 8
                     Thread-0----> 9
                     main Thread -->5
                     main Thread -->6
                     main Thread -->7
                     main Thread -->8
                     main Thread -->9

                     */
                    // 再运行后面的线程
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
            System.out.println("main Thread -->"+i++);
        }
    }
}
class ThreadTet implements Runnable{

    @Override
    public void run() {
        String str=new String();
        int i=0;
        for(int x=0;x<10;x++){
            System.out.println(Thread.currentThread().getName()+"----> "+""+i++);
        }
    }
}