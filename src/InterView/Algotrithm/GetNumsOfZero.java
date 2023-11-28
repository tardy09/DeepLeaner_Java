package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/3/21.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */
public class GetNumsOfZero {
    public int NumberOf1(int n) {
        int count=0;
        int flag=1;
        /*
          该解法里面的循环次数等于二进制的位数
         */
        while (flag!=0){
            int temp=n&flag;
            if (temp!=0) {
                count++;
            }
           flag<<=1;
        }
        return count;
    }
    public int NumberOf2(int n) {
        int count=0;
         while (n!=0){
             n=n&n-1;
             count++;
        }
        return count;
    }
    public static void main(String [] args){
        GetNumsOfZero getNumsOfZero=new GetNumsOfZero();
       int re= getNumsOfZero.NumberOf1(-7);
        System.out.println(re);
    }
}
