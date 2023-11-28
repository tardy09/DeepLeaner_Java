package GeneralType;

/**
 * Created by Administrator on 2016/11/12.
 * 接口也可以是泛型的，我们之前介绍过的Comparable和Comparator接口都是泛型的，
 * 它们的代码如下：
 *
 */
public interface MyComparable<T> {
    public int compareTo(T o);
}
