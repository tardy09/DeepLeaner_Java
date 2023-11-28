package PatternDesign.builder.demo;

/**
 * Created by Administrator on 2016/11/30.
 */
public class HomeProductFactory extends ProductFactory {
    @Override
    public Productor getProduct() {
        return new Productor("房顶","墙","地板");
    }
}
