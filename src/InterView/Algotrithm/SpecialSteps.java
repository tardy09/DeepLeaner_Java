package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/3/20.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 *  1--->1
 *  2--->2
 *  3--->4 第一次跳一个台阶 f(2)+第一次跳2个f（1）+第一次跳3个=4=2+1+1=f(2)+f(1)+1=2f(2)=
 *  4----  第一次跳一个f(3)+第一次跳2个f(2)+第一次跳3个f(1)+第一次跳4个=4+2+1+1=8=f(3)+f(2)+f(1)+1=f(3)-1+f(3)+1=2f(3)=2(2f(2))=4f(2)=2^2 f(2)
 *  5----   第一次跳一个f(4)+第一次跳2个f(3)+第一次跳3个f(2)+第一次跳4个f(1)+第一次跳5个=f(4)+f(3)+f(2)+f(1)+1=2f(4)=2(4f(2))=8f(2)=2^3 f(2)
 *
 *
 *    n>=3
 *    f（n）=f(n-1)+..+f(1)+1 = n>=3  ==2^(n-2) *f(2)
 */
public class SpecialSteps {
    public int JumpFloorII(int target) {
        int res=2;
       if(target==1||target==2||target==0){
           return target;
       }
       for (int i=1;i<=target-2;i++){
             res*=2;
       }
       return res;
    }
}
