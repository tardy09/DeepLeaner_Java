package PatternDesign.Decorator;

/**
 * Created by Administrator on 2016/12/6.
 */
public class ConcreteDecorator extends Decorator {
    /**
     * 构造方法传入组件对象
     *
     * @param component
     */
    public ConcreteDecorator(Component component) {
        super(component);
    }
    @Override
    public void operation() {
        //调用父类的方法，在此之前可以添加一些附加的操作
        super.operation();
    }
}
