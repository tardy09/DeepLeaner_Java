package InterView.Algotrithm;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/4/20.
 */
public class FindGreatestSumOfSubArraySoluction {
    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
     * 他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,
     * 问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 你会不会被他忽悠住？(子向量的长度至少是1)
     * @param array
     * @return
     *  动态规划
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length<=0){
            return -1;
        }
        int s=array.length;
        int f[]=new int[s];
        f[0]=array[0];
        for (int i = 1; i <s ; i++) {
            if(f[i-1]<=0){
                f[i]=array[i];
            }else {
                f[i]=f[i-1]+array[i];
            }
        }
        Arrays.sort(f);
        System.out.println("");
        return f[s-1];

    }

    /**
     * 递推
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] array){
        if(array==null){
            return -1;
        }
        int max=Integer.MIN_VALUE;
        int cursum=0;
        for (int i = 0; i <array.length ; i++) {
            if(cursum<=0){
                cursum=array[i];
            }
            else {
                cursum+=array[i];
            }
            if(cursum>max){
                max=cursum;
            }
        }
        return max;
    }
    public static void main(String [] args){
        int [] arr={-2,-8,-1,-5,-9};
        new FindGreatestSumOfSubArraySoluction().FindGreatestSumOfSubArray(arr);
        System.out.println("vvvvv");
    }
}
