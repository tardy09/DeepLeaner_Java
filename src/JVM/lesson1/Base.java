package JVM.lesson1;

/**
 * Created by Administrator on 2017/5/31.
 *
 * 通常类在首次被使用的时候会执行初始化操作，为类（静态）变量赋予正确的初始化值
 * 通常在Java代码里面，一个正确的初始化值是通过类变量初始化语句或者静态初始化块来完成的，
 * 而我们这里说到的主动使用包括：
 *
 *   1.  创建类的实例，
 *   2.调用类的静态方法
 *   3.使用类的非常量静态字段
 *   4.使用JavaApi的某些反射方法
 *    5.初始化某个子类
 *    6.含有main（）方法的某个类运行
 *
 *    %%%%%%%%%%%%%%%%%%%%%%%%z注意这个和类的初始化时机是不一样的;
 *       类的初始化时机主要在：
 *         1.创建类的实例的时候：主要集中在a.显示的使用New关键字来创建对象 b.使用反射类创建对象 c.使用反序列化来创建对象
 *                                    d.调用类的clone方法（不会调用类的任何构造方法）
 *         2.使用该类的静态方法，.使用该而该类的静态字段（如果该类的静态字段是final类型吗，并且在编译期间已经得以确定下来，那么该类就不会被初始化）
 *         3.初始化该类的子类
 *         4.运行该类，该类里面含有main方法
 */
public class Base {

    
}