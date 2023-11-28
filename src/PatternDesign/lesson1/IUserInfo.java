package PatternDesign.lesson1;

/**
 * Created by Administrator on 2016/11/18.
 *
 * 在java当中，每个类（类java.lang.Object除外）有且仅有一个直接父类
 * （下面有注释），只能多继承接口，不能多继承类
 * ，接口之间用逗号隔开（注意继承接口时要实现接口中的方法）
 * ava不支持多继承，但是通过一些巧妙的设计来达到和多继承同样的效果
 * 通过接口、内隐类，继承、实现，互相配合，达到多继承的效果
 * 1、Java中一个类不能继承多个具体class。
 * 2、一个类只可继承自一个具体 class，但可实现多个接口。
 * interface不涉及到实现细节，不与任何存储空间有关连。
 * 可以实现合并多个 interface ，达到可向上转型为多种基类的目的。
 * 新类可继承自一个具象class，其余继承都得是interfaces。
 * 3、outer class不可继承自多个具体 class，可在其内部设多个inner class，
 * 每个inner class都能各自继承某一实现类。 inner class不受限于outer class
 * 是否已经继承自某一实现类。 4、inner class可以说是多重继承问题的完整解决方案
 * 。 inner class 可 “继承自多个具象或抽象类”。
 * 一个类不能继承自多个一般类。
 */
public interface IUserInfo extends IUserBO,IUserBiz {

}
