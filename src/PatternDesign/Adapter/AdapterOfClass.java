package PatternDesign.Adapter;

/**
 * Created by Administrator on 2016/11/13.
 */
public class AdapterOfClass extends Adaptee implements Target {
    @Override
    public void request() {
        super.specificRequest();
    }
}
