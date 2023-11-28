package PatternDesign.ObserverPattern;

/**
 * Created by Administrator on 2017/2/28.
 */
public class ConcreteSubject extends Subject {
    /// <summary>
    /// 具体观察者的状态
    /// </summary>
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
