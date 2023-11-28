package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/3/20.
 */
public class FiiiaNumber {
    public int Fibonacci(int n) {
        int  precious=0;
        int  current=1;
        int result=0;
        if(n==0){

            return 0;
        }else if(n==1){

            return 1;
        }
        else {
            //通过变量 将上次递归的结果 临时存储起来，方便下一次直接使用
            //避免递归
//            precious=Fibonacci(n-2);
//            current=Fibonacci(n-1);

            for (int i=2;i<=n;i++) {
                result=precious+current;
                precious=current;
                current=result;
            }
            return result;
        }
    }
    public int Fibonacci2(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int [] temp=new int[n+1];
        temp[0]=0;
        temp[1]=1;
        for(int i=2;i<=n;i++){
            temp[i]=temp[n-2]+temp[n-1];
        }
        return temp[n];
    }
    public static void main(String [] args){
        FiiiaNumber fiiiaNumber=new FiiiaNumber();
        int res =fiiiaNumber.Fibonacci2(3);
        System.out.println(res);
    }
}
