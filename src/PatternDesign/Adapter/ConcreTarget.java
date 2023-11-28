package PatternDesign.Adapter;

/**
 * Created by Administrator on 2016/11/13.
 */
public class ConcreTarget implements Target {
    @Override
    public void request() {
        System.out.println("普通类 具有 普通功能...");
    }
}
