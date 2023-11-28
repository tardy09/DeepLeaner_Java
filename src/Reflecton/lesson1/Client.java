package Reflecton.lesson1;

/**
 * Created by Administrator on 2016/11/19.
 * 关于配置文件里面
 * //fields代表该Bean所包含的属性, name为属性名称,
 //value为属性值(属性类型为JSON支持的类型),
 //ref代表引用一个对象(也就是属性类型为Object,但是一定要引用一个已经存在了的对象)
 User{id=1, name='882833832', password='uu2'}
 Bean{name='hhhs', flag=false}
 ComplexBean{name='complex-bean-name', refBean=Bean{name='hhhs', flag=false}}

 */
public class Client {
  public static void main(String [] args){
      ObjectPool pool=ObjectPool.init("Reflecton/lesson1/config.json");
      User user=pool.getObject("id1");
      System.out.println(user);//User{id=0, name='null', password='null'}
      Bean bean=pool.getObject("id2");
      System.out.println(bean);//Bean{name='null', flag=false}
      ComplexBean complexBean=pool.getObject("id3");
      System.out.println(complexBean);
      /**
       * 可以看到Client获取到的对象的成员变量全都是默认值,既然我们已经使用了JSON这么优秀的工具,
       * 我们又学习了动态调用对象的方法,
       * 那么我们就通过配置文件来给对象设置值(在对象创建时), 新的配置文件形式如下:
       */

  }
}
