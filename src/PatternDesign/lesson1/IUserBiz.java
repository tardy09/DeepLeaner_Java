package PatternDesign.lesson1;

/**
 * Created by Administrator on 2016/11/18.
 *
 * 负责用户的行为，完成用户信息的维护和变更
 */
public interface IUserBiz {
    boolean changePassword();
    boolean deleteUser(UserBO userBO);
    void mapUser(UserBO userBO);
    boolean addOrg(IUserBO userBO,int orgID);
    boolean addRole(UserBO userBO,int roleID);


}
