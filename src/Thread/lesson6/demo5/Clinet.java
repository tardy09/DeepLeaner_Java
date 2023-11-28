package Thread.lesson6.demo5;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/2/24.
 */
public class Clinet {
    public static void main(String []args) throws Exception {
        MyExecutor myExecutor=new MyExecutor();
        System.out.println("ahahhahah");
          MyFuture res=  myExecutor.execute(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                System.out.println("耗时任务完成");
                return 340;
            }
        });

        System.out.println("异步执行结果是...."+res.get().toString());
        System.out.println("sdjsjjsjsj");
        System.out.println("weuw2y834yt89qw345rq3t6q34890q238589q1589189t68948953q289");
    }
}
