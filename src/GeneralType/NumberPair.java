package GeneralType;

/**
 * Created by Administrator on 2016/11/12.
 * 定义一个子类NumberPair，限定两个类型参数必须为Number
 * 指定边界后，类型擦除时就不会转换为Object了，
 * 而是会转换为它的边界类型，这也是容易理解的。
 *
 */
public class NumberPair<U extends Number, V extends Number> extends Pair<U, V> {

    public NumberPair(U first, V second) {
        super(first, second);
    }
    /**
     * 限定类型后，就可以使用该类型的方法了，比如说，对于NumberPair类，
     * first和second变量就可以当做Number进行处理了，比如可以定义一个求和方法，如下所示
     * @return
     */
    public double sum(){
        return getFirst().doubleValue()
                +getSecond().doubleValue();
    }
}
