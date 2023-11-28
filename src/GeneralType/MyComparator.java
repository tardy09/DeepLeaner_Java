package GeneralType;

/**
 * Created by Administrator on 2016/11/12.
 */
public interface MyComparator<T> {
    int compare(T o1, T o2);
    boolean equals(Object obj);
}
