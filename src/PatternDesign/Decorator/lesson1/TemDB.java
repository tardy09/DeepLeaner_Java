package PatternDesign.Decorator.lesson1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/6.
 *  在内存里面模拟数据库，准备点测试数据，好计算奖金
 */
public class TemDB {
    private TemDB(){

    }
    public static Map<String,Double> mapMonthSaleMoney=new HashMap<>();
    static {
        //填充测试数据
        mapMonthSaleMoney.put("张三",10000.0);
        mapMonthSaleMoney.put("李四",20000.0);
        mapMonthSaleMoney.put("王五",30000.0);
    }
}
