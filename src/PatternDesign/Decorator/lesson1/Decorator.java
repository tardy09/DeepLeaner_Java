package PatternDesign.Decorator.lesson1;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/6.
 */
public abstract class Decorator extends Component {
    //持有装饰器的组件对象
    protected Component component;
    /**
     * 通过装饰器传入装饰的对象
     * @param component
     */
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public double calcPrice(String user, Date begin, Date end) {
        //转调组件对象的方法
        return component.calcPrice(user,begin,end);
    }
}
