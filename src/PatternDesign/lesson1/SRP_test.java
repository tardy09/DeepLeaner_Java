package PatternDesign.lesson1;

/**
 * Created by Administrator on 2016/11/18.
 */
public class SRP_test {
    public static void main(String [] args){
        //分清职责之后的代码示例
        IUserInfo userInfo=new UserInfo();
        //我要进行属性赋值了，我是一个纯粹的BO--Domian对象
        IUserBO userBO=userInfo;
        userBO.setPassWord("aaa");
        //我要执行动作了，我就认为是一个业务逻辑代表
        IUserBiz userBiz=userInfo;
        userInfo.deleteUser(null);
        //分析 通过将一个接口拆解成为两个接口，实现了单一职责原则
        // 应该有且仅有一个原因引起类的变更。
    }
}
