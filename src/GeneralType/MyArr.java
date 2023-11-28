package GeneralType;

/**
 * Created by Administrator on 2016/11/12.
 */

public class MyArr<T> {
    /**
     * 泛型方法中，一种常见的场景是限定类型必须实现Comparable接口，
     * 我们来看代码
     * @param arr
     * @param <T>
     * @return
     *
     * ，计算最大值需要进行元素之间的比较，要求元素实现Comparable接口，
     * 所以给类型参数设置了一个上边界Comparable，T必须实现Comparable接口。
     *
     * <T extends Comparable<T>>是一种令人费解的语法形式，这种形式称之为递归类型限制，
     * 可以这么解读，T表示一种数据类型，
     * 必须实现Comparable接口，且必须可以与相同类型的元素进行比较
     */
    public static <T extends Comparable<T>> T max(T[] arr){
        T max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i].compareTo(max)>0){
                max = arr[i];
            }
        }
        return max;
    }
}
