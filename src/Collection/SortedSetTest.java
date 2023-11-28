package Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2016/11/8.
 *
 * 数组与其它容器的区别体现在三个方面：效率，类型识别以及可以持有primitives。
 * 数组是Java提供的，能随机存储和访问reference序列的诸多方法中的，最高效的一种。
 * 数组是一个简单的线性序列，所以它可以快速的访问其中的元素。但是速度是有代价的；
 * 当你创建了一个数组之后，它的容量就固定了，而且在其生命周期里不能改变。
 * 也许你会提议先创建一个数组，等到快不够用的时候，再创建一个新的，
 * 然后将旧的数组里的reference全部导到新的里面。其实（我们以后会讲的）ArrayList就是这么做的
 * 。但是这种灵活性所带来的开销，使得ArrayList的效率比起数组有了明显下降。
 */
public class SortedSetTest {
    /**
     * http://www.open-open.com/lib/view/open1474167415464.html
     * http://blog.csdn.net/zsw101259/article/details/7570033
     * http://blog.csdn.net/hudashi/article/details/6943522
     * http://blog.csdn.net/qq_33290787/article/details/51781036
     * https://zhuanlan.zhihu.com/p/23511594?refer=dreawer
     */
    class human
    {
        private String name;
        private int age;
       human(){

       }human(int age){
        this.age=age;
    }
    human(String name,int age){
        this.age=age;
        this.name=name;
    }
        human(String name)
        {
            this.name = name;
        }
        public String getName()
        {
            return name;
        }
        public int getAge()
        {
            return age;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
    class student extends human
    {
        student(String name)
        {
            super(name);
        }
        student(String name,int age){
            //super(age);
          //  super(name);
            super(name,age);
        }
        @Override
        public String toString() {
            return "{"+this.getName()+","+this.getAge()+"}";
        }
    }
    class compar implements Comparator<human>
//把这里改成 class compar implements Comparator<student>就会编译失败
//<? super E>不是允许 本类和本类的父类吗
//student的父类不就是human吗 为什么这样就不可以呢？为什么反过来就可以？
            /**
             * ? super E是E和E的父类的意思...
             但是这个E要知道是你new TreeSet<这里这个是E>,
             也就是说你new TreeSet<human>时候这个E是human,
             这样就好理解在把Comparator的泛型改成了student之后,
             就变成了new TreeSet<human>(Comparator<student super human>)了..
             */
    {
        public int compare(human p1, human p2)
        {
            //自定义根据年龄比较大小，如果年龄相等，则退而求其次，根据姓名来比较
            int temp = new Integer(p1.getAge()).compareTo(new Integer(p2.getAge()));
            if(temp ==0)
            {
                return p1.getName().compareTo(p2.getName());
            }
            return temp;
        }
    }
    public static void  main(String args[]){
        /**
         * TreeSet是JAVA中集合的一种，TreeSet 是一个有序的集合，它的作用是提供有序的Set集合。它继承于AbstractSet抽象类，实现了NavigableSet<E>,Cloneable,java.io.Serializable接口。

         　　一种基于TreeMap的NavigableSet实现。
         */

        /**
         * 此构造函数构造一个空树集，将根据给定的比较器进行排序  TreeSet (比较器 comp)
         */
        //非静态内部类因为是了属于对象的，所以初始化时需要先初始化一个外部类实例对象
        // ，然后使用此对象调用内部类的构造方法。静态内部类属于类本身，初始化时直接使用外部类调用静态内部类的构造方法即可。
        SortedSetTest.compar compar=new SortedSetTest().new compar();
        Set<human> treeSet=new TreeSet<human>(compar);
        SortedSetTest.student student1=new SortedSetTest().new student("danfeng1",6);
        SortedSetTest.student student2=new SortedSetTest().new student("danfeng2",8);
        SortedSetTest.student student3=new SortedSetTest().new student("danfeng3",10);
        SortedSetTest.student student4=new SortedSetTest().new student("danfeng4",12);
        SortedSetTest.student student5=new SortedSetTest().new student("danfeng5",9);
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        treeSet.add(student4);
        treeSet.add(student5);
        //TreeSet不支持快速随机遍历，只能通过迭代器进行遍历！
        for(Iterator iterator=treeSet.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}
