package PatternDesign.Decorator.lesson1;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/6.
 */
public abstract class Component {
    /**
     *  计算某个人在某段时间内的奖金
     * @param user
     * @param begin  开始时间
     * @param end    结束时间
     * @return 某个人在某段时间内的奖金
     */
    public abstract double calcPrice(String user, Date begin,Date end);
}
