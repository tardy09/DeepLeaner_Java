package PatternDesign.ObserverPattern;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Client {
    /**
     *  观察者模式解除了主题和具体观察者的耦合，让耦合的双方都依赖于抽象，而不是依赖具体。从而使得各自的变化都不会影响另一边的变化
     * @param args
     */
    public static void main(String [] args){

        ConcreteSubject concreteSubject=new ConcreteSubject();
        concreteSubject.Attach(new ConcreteObserver("dfa",concreteSubject));
        concreteSubject.Attach(new ConcreteObserver("dsafa",concreteSubject));
        concreteSubject.Attach(new ConcreteObserver("daaafa",concreteSubject));
        concreteSubject.Attach(new ConcreteObserver("aqadfa",concreteSubject));
        concreteSubject.Attach(new ConcreteObserver("aqdfa",concreteSubject));
        concreteSubject.setSubjectState("ready");
        concreteSubject.Notify();

    }
}
