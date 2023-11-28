package GeneralType;

/**
 * Created by Administrator on 2016/11/12.
 * 超类型通配符另一个常用的场合是Comparable/Comparator接口。
 * 实现灵活比较
 */
public class SuperGnerttype {

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
     * 就这么修改一下，就可以了，这种写法比较抽象，将T替换为Child，就是：

     Child extends Comparable<? super Child>
     <? super Child>可以匹配Base，所以整体就是匹配的
     * @param arr
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max2(DynamicArray<T> arr){
        T max = arr.get(0);
        for(int i=1; i<arr.size(); i++){
            if(arr.get(i).compareTo(max)>0){
                max = arr.get(i);
            }
        }
        return max;
    }
    //Base代码很简单，实现了Comparable接口，根据实例变量sortOrder进行比较
    class Base implements Comparable<Base>{
        private int sortOrder;

        public Base(int sortOrder) {
            this.sortOrder = sortOrder;
        }

        @Override
        public int compareTo(Base o) {
            if(sortOrder < o.sortOrder){
                return -1;
            }else if(sortOrder > o.sortOrder){
                return 1;
            }else{
                return 0;
            }
        }
    }
    //Child非常简单，只是继承了Base。注意，Child没有重新实现Comparable接口，
    // 因为Child的比较规则和Base是一样的。我们可能希望使用前面的max方法操作Child容器
    class Child extends Base {
        public Child(int sortOrder) {
            super(sortOrder);
        }
    }
    public void compareTest(){
        DynamicArray<Child> childs = new DynamicArray<Child>();
        childs.add(new Child(20));
        childs.add(new Child(80));
       // Child maxChild = max(childs);//java会提示编译错误，类型不匹配。为什么不匹配呢
        /**
         * 但类型T的要求是extends Comparable<T>，
         * 而Child并没有实现Comparable<Child>，它实现的是Comparable<Base>。
         */
        Child maxChild2 = max2(childs);

    }
}
