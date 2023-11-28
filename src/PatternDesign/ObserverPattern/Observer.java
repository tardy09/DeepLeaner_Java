package PatternDesign.ObserverPattern;

/**
 * Created by Administrator on 2017/2/28.
 * 抽象观察者类，为所有具体观察者定义一个接口，在得到通知时更新自己
 */
public abstract class Observer {
    public abstract void Update();
}
