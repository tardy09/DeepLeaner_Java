package PatternDesign.Decorator.lesson1;

/**
 * Created by Administrator on 2016/12/6.
 */
public class Client {
  public static void main(String [] args){
      //先创建出基本业务奖金的类
      Component component=new ConcreteComponent();
      /**
       * 然后对计算出来的基本业务奖金进行装饰
       * 各个装饰者之间最好不要有先后的限制
       * 也就是先后问题
       */
      Decorator d1=new MonthPrizeDecorator(component);
      Decorator d2=new SumPrizeDecorator(d1);
      double zs=d2.calcPrice("张三",null,null);
      System.out.println("=======张三应该得到的奖金: "+zs);
      double ls=d2.calcPrice("李四",null,null);
      System.out.println("=======李四应该得到的奖金: "+ls);
      //如果是业务经理，还需要计算团队的奖金
      Decorator d3=new GroupPrizeDecorator(d2);
      double ww=d3.calcPrice("王五",null,null);
      System.out.println("=======王五应该得到的奖金: "+ww);

  }
    /**
     *
     *  王五当月的业务奖金：900.0
        王五累积奖金：1000.0
        王五当月团队业务奖金：600.0
        =======王五应该得到的奖金: 2500.0
     */
}
