package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/3/20.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *  n>=3
 *  1.第一次跳1一个台阶  则 f（n-1）
 *  2.第一次跳两个台阶  则 f（n-2）
 *  f(n)=f(n-1)+f(n-2)
 */
public class ForSteps {

    public int JumpFloor(int target) {
        int first=1;
        int secord=2;
        int third=0;
        if (target==0||target==1||target==2){
            return target;
        }
        for (int i=3;i<=target ;i++){
            third=first+secord;
            first=secord;
            secord=third;
        }
        return third;
    }

}
