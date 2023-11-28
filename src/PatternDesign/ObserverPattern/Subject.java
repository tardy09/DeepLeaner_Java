package PatternDesign.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 * 抽象主题类
 */
public abstract class Subject
{
    List<Observer> observers=new ArrayList<>();
    public void Attach(Observer observer)
    {
        observers.add(observer);
    }

    /// <summary>
    /// 移除观察者
    /// </summary>
    /// <param name="observer"></param>
    public void Detach(Observer observer)
    {
        observers.remove(observer);
    }
    /// <summary>
    /// 向观察者（们）发出通知
    /// </summary>
    public void Notify()
    {
        for (Observer o : observers)
        {
            o.Update();
        }
    }
}
