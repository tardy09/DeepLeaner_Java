package PatternDesign.Decorator.lesson1;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/6.
 */
public class GroupPrizeDecorator extends Decorator {

    /**
     * 通过装饰器传入装饰的对象
     *
     * @param component
     */
    public GroupPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calcPrice(String user, Date begin, Date end) {
        double money=super.calcPrice(user,begin,end);
        double group=0.0;
        for(double d:TemDB.mapMonthSaleMoney.values()){
            group+=d;
        }
        double prize=group*0.01;
        System.out.println(user+"当月团队业务奖金："+prize);
        return money+prize;
    }
}
