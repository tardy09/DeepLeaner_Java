package InterView;

/**
 * Created by Administrator on 2017/4/15.  不一定连续
 */
public class LISproblem {
    public  int  longestIncresingSequece(int [] arr){
        int s=arr.length;
        int d[]=new int[s];//存储中间状态
        //初始化d[i] 全部为1
        for (int i = 0;i<s ; i++) {
            d[i]=1;
        }
        //标记全局的最大中
        int max=1;
        for (int i = 0; i <s ; i++) {
//            int j=i-1;
//                while(j>=0){
//                    if(arr[j]<=arr[i]){ //递增的序列结构
//                        d[i]=Math.max(max,d[j--])+1;//得到最新的d[i]
//                        if(d[i]>max){
//                            max=d[i];
//                        }
//                    }else {
//                        d[i]=Math.max(max,d[j--]);
//                    }
//                }
            for (int j = 0; j <i ; j++) {
                if(arr[j]<arr[i]&&d[j]+1>d[i]){
                    d[i]=d[j]+1;
                }else {
                    d[i]=d[i];
                }
                if(d[i]>max){
                    max=d[i];
                }
            }
        }
        return max;
    }
    public static void main(String [] args){
        int [] arr={5,3,4,8,6,7};
        int result=new LISproblem().longestIncresingSequece(arr);
        System.out.println("v  v    v        v");
    }
}
