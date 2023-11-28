package PatternDesign.builder.demo;

/**
 * Created by Administrator on 2016/11/30.
 */
public class RobotProductFayctory  extends ProductFactory{
    @Override
    public Productor getProduct() {
        return new Productor("head","body","leg");
    }
}
