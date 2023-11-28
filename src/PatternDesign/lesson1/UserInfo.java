package PatternDesign.lesson1;

/**
 * Created by Administrator on 2016/11/18.
 */
public class UserInfo implements IUserInfo {
    @Override
    public boolean changePassword() {
        return false;
    }

    @Override
    public boolean deleteUser(UserBO userBO) {
        return false;
    }

    @Override
    public void mapUser(UserBO userBO) {

    }

    @Override
    public boolean addOrg(IUserBO userBO, int orgID) {
        return false;
    }

    @Override
    public boolean addRole(UserBO userBO, int roleID) {
        return false;
    }

    @Override
    public void setUserID(String userID) {

    }

    @Override
    public String getUserID() {
        return null;
    }

    @Override
    public void setPassWord(String passWord) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public String getUserName() {
        return null;
    }
}
