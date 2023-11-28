package Thread.lesson3.demo1;

/**
 * Created by Administrator on 2016/12/21.
 */
public class IncreaseThread extends Thread
{
    private NumberHolder numberHolder;

    public IncreaseThread(NumberHolder numberHolder)
    {
        this.numberHolder = numberHolder;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 20; ++i)
        {
            // 进行一定的延时
            try
            {
                Thread.sleep((long) Math.random() * 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            // 进行增加操作
            numberHolder.increase();
        }
    }
}


