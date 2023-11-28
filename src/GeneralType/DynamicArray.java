package GeneralType;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/12.
 *
 * 这就是一个简单的容器类，适用于各种数据类型，且类型安全。
 * 本节后面和后面两节还会以DynamicArray为例进行扩展，以解释泛型概念。

 具体的类型还可以是一个泛型类，比如，可以这样写：
 DynamicArray<Pair<Integer,String>> arr = new DynamicArray<>()
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Object[] elementData;

    public DynamicArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if(oldCapacity>=minCapacity){
            return;
        }
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public E get(int index) {
        return (E)elementData[index];
    }

    public int size() {
        return size;
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }
//    public static void main(String agrs[]){
//        DynamicArray<Pair<Integer,String>> arr = new DynamicArray<>();
//    }
    //除了泛型类以外，方法也可以是泛型的与它所在的类是不是泛型没有什么关系。

    /**
     * 这个方法就是一个泛型方法，类型参数为T，放在返回值前面，它可以这么调用：
     indexOf(new Integer[]{1,3,5}, 10)
     算法的基本过程与具体数据类型没有什么关系，通过泛型，
     它就可以方便的应用于各种数据类型，且编译器保证类型安全。
     也可以这么调用：
     indexOf(new String[]{"hello","老马","编程"}, "老马")
     * @param arr
     * @param elm
     * @param <T>
     * @return
     */
    public static <T> int indexOf(T[] arr, T elm){
    for(int i=0; i<arr.length; i++){
        if(arr[i].equals(elm)){
            return i;
        }
    }
    return -1;
}

    /**
     * 与泛型类一样，类型参数可以有多个，多个以逗号分隔，比如
     * 与泛型类不同，调用方法时一般并不需要特意指定类型参数的实际类型是什么，
     * 比如调用makePair：
     makePair(1,"老马");
     * @param first
     * @param second
     * @param <U>
     * @param <V>
     * @return
     */
    public static <U,V> Pair<U,V> makePair(U first, V second){
        Pair<U,V> pair = new Pair<>(first, second);
        return pair;
    }

    /**
     * E是DynamicArray的类型参数，T是addAll的类型参数，T的上界限定为E
     * @param c
     * @param <T>
     */
    public <T extends E> void addAll(DynamicArray<T> c) {
        for(int i=0; i<c.size; i++){
            add(c.get(i));
        }
    }
    //更为简洁的通配符形式

    /**
     * 这个方法没有定义类型参数，c的类型是DynamicArray<? extends E>，?表示通配符，
     * <? extends E>表示有限定通配符
     * ，匹配E或E的某个子类型，具体什么子类型，我们不知道。
     * @param c
     */
    public void addAll2(DynamicArray<? extends E> c) {
        for(int i=0; i<c.size; i++){
            add(c.get(i));
        }
    }

    /**
     * 还有一种通配符，形如DynamicArray<?>，称之为无限定通配符，
     * 我们来看个使用的例子，在DynamicArray中查找指定元素，代码如下
     * @param arr
     * @param elm
     * @return
     * 等价于
     * public static <T> int indexOf(DynamicArray<T> arr, Object elm)
     */
    public static int indexOf(DynamicArray<?> arr, Object elm){
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).equals(elm)){
                return i;
            }
        }
        return -1;
    }
    public static void swap2(DynamicArray<?> arr, int i, int j){
        Object tmp = arr.get(i);
//        arr.set(i, arr.get(j));  //编译失败
//        arr.set(j, tmp);tmp  //编译失败
    }
    private static <T> void swapInternal(DynamicArray<T> arr, int i, int j){
        T tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }

    /**
     * Java容器类中就有类似这样的用法，公共的API是通配符形式，形式更简单，
     * 但内部调用带类型参数的方法
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(DynamicArray<?> arr, int i, int j){
        swapInternal(arr, i, j);
    }

    /**
     * 参数类型间的依赖关系
     除了这种需要写的场合，如果参数类型之间有依赖关系，也只能用类型参数，
     比如说，看下面代码，将src容器中的内容拷贝到dest中：
     * @param dest
     * @param src
     * @param <D>
     * @param <S>
     */
    public static <D,S extends D> void copy(DynamicArray<D> dest,
                                            DynamicArray<S> src){
        for(int i=0; i<src.size(); i++){
            dest.add(src.get(i));
        }
    }
    //简化上面的代码

    /**
     *
     * @param dest
     * @param src
     * @param <D>
     *     S和D有依赖关系，要么相同，要么S是D的子类，否则类型不兼容，有编译错误。不过，
     *     上面的声明可以使用通配符简化一下，两个参数可以简化为一个，如下所示：
     */
    public static <D> void copy2(DynamicArray<D> dest,
                                DynamicArray<? extends D> src){
        for(int i=0; i<src.size(); i++){
            dest.add(src.get(i));
        }
    }

    /**
     * 通配符与返回值

     还有，如果返回值依赖于类型参数，也不能用通配符，
     比如，计算动态数组中的最大值，如下
     * @param arr
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T max(DynamicArray<T> arr){
        T max = arr.get(0);
        for(int i=1; i<arr.size(); i++){
            if(arr.get(i).compareTo(max)>0){
                max = arr.get(i);
            }
        }
        return max;
    }

    /**
     * 还有一种通配符，与形式<? extends E>正好相反，它的形式为<? super E>，称之为超类型通配符，
     * 表示E的某个父类型，它有什么用呢？有了它，我们就可以更灵活的写入了。
     * @param dest
     * 将当前容器中的元素添加到传入的目标容器中父类容器
     */
    public void copyTo(DynamicArray<? super E> dest){
        for(int i=0; i<size; i++){
            dest.add(get(i));
        }
    }
}
