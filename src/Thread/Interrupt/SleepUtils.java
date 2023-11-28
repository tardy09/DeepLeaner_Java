package Thread.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/21.
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
