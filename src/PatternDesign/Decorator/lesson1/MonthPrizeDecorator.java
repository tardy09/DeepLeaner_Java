package PatternDesign.Decorator.lesson1;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/6.
 *
 * 个人当月的业务奖金等于当月的销售额度x3%
 */
public class MonthPrizeDecorator extends Decorator {
    /**
     * 通过装饰器传入装饰的对象
     *
     * @param component
     */
    public MonthPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calcPrice(String user, Date begin, Date end) {
        //先计算前面计算出来的奖金
        double money=super.calcPrice(user,begin,end);
        double prize=TemDB.mapMonthSaleMoney.get(user)*0.03;
        System.out.println(user+"当月的业务奖金："+prize);
        return money+prize;
    }
}
