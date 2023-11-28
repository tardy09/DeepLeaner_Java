package GeneralType;

/**
 * Created by Administrator on 2016/11/12.
 *
 *
    类型参数可以有多个，Pair类中的first和second可以是不同的类型，
    多个类型之间以逗号分隔
 可以这样使用：
 Pair<String,Integer> pair = new Pair<String,Integer>("老马",100);

 Java有Java编译器和Java虚拟机，编译器将Java源代码转换为.class文件
 ，虚拟机加载并运行.class文件。对于泛型类，Java编译器会将泛型代码转换
 为普通的非泛型代码，就像上面的普通Pair类代码及
 其使用代码一样，将类型参数T擦除，替换为Object，插入必
 要的强制类型转换。Java虚拟机实际执行的时候，它是不知道
 泛型这回事的，它只知道普通的类及代码。

 再强调一下，Java泛型是通过擦除实现的，类定义中的类型参数如T会
 被替换为Object，在程序运行过程中，不知道泛型的实际类型参数，
 比如Pair<Integer>，运行中只知道Pair，而不知道Integer，
 认识到这一点是非常重要的，它有助于我们理解Java泛型的很多限制
 使用泛型，还可以省去繁琐的强制类型转换，再加上明确的类型信息，代码可读性也会更好。

 */
public class Pair<U, V> {

    U first;
    V second;

    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}