package PatternDesign.lesson1;

/**
 * Created by Administrator on 2016/11/18.
 * IUserBO负责用户的属性--收集和反馈用户信息
 */
public interface IUserBO {
    //用户信息--用户属性单独抽取
    void setUserID(String userID);
    String getUserID();
    void setPassWord(String passWord);
    String getPassword();
    void setUserName(String userName);
    String getUserName();
}
