package Enum.lesson2;

/**
 * Created by Administrator on 2016/11/15.
 * 另外，也可以在枚举类里面定义抽象方法，在一个枚举类里面可以一个或者多个抽象方法，
 * 需要注意的是枚举类里面的每个对象都必须单独的实现此方法
 */
public enum  AbstractColor {
    RED{
        @Override
        public String getColor() {
            return null;
        }
    },
    Grren{
        @Override
        public String getColor() {
            return null;
        }
    },
    Blue{
        @Override
        public String getColor() {
            return null;
        }
    };
    public abstract String getColor();

}
