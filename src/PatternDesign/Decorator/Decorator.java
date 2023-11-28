package PatternDesign.Decorator;

/**
 * Created by Administrator on 2016/12/6.
 *  装饰器对象，维持一个组件对象的接口对象，并定义一个和
 *  组件接口一致的接口
 */
public abstract class Decorator  extends Component{
    //持有组件对象
    protected Component component;
    /**
     *  构造方法传入组件对象
     * @param component
     */
    public Decorator(Component component) {
        this.component = component;
    }
    @Override
    public void operation() {
        //转发组件对象，可以在转发前执行一些附加的功能
        component.operation();
    }
}
