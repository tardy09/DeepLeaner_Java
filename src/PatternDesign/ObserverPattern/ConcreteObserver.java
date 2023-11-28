package PatternDesign.ObserverPattern;

/**
 * Created by Administrator on 2017/2/28.
 */
public class ConcreteObserver extends Observer{
    private String observerState;
    private String name;
    private ConcreteSubject subject;

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void Update() {
        observerState = subject.getSubjectState();
        System.out.println(name+"    .from subject   "+subject);

    }
}
