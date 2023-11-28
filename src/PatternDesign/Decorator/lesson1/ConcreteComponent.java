package PatternDesign.Decorator.lesson1;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/6.
 * 基本的实现计算奖金的类
 */
public class ConcreteComponent extends Component {
    @Override
    public double calcPrice(String user, Date begin, Date end) {
        return 0;
    }
}
