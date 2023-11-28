package PatternDesign.Decorator.lesson1;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/6.
 */
public class SumPrizeDecorator extends Decorator {
    /**
     * 通过装饰器传入装饰的对象
     *
     * @param component
     */
    public SumPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calcPrice(String user, Date begin, Date end) {
        //先计算当前运算出来的奖金
        double money=super.calcPrice(user,begin,end);
        //然后计算累计的奖金---实际上应该按照人员获取累计的业务额，这里为了简单
        //假定，大家的累积业务额度为1000000元，
        double prize=1000000*0.001;
        System.out.println(user+"累积奖金："+prize);
        return money+prize;
    }
}
