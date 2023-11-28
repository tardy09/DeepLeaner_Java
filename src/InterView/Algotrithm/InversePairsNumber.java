package InterView.Algotrithm;

import java.util.*;

/**
 * Created by Administrator on 2017/4/18.
 */
public class InversePairsNumber {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，
     * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P%1000000007
     *
     * eg> 1,2,3,4,5,6,7,0   -----7
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        int count=0;
        int s=array.length;
        if(s==0||s==1){
            return 0;
        }
        /**
         * 暴力解法 每次都从当前数在前面找 比他大的数  复杂度为 O(n^2)
         */
        Map<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i <s ; i++) {
            hashMap.put(array[i],i);
        }
        Arrays.sort(array);
        /** 0 1 2 3 4 5            5,0,2,1,4,3
         *  1,3,2,5,4,0    排序后  0,1,2,3,4,5
         *  0 0 1 0 1 5
         */

        for (int i = 0; i <s ; i++) {
            int index=hashMap.get(array[i]);
            if(i+1<s){
                int nextIndex=hashMap.get(array[i+1]);
                if(index>nextIndex){
                    count+=(index-nextIndex);
                }
            }
        }
        return count%1000000007;
    }
    public int InversePairs2(int [] array){
        if(array==null||array.length==1){
            return 0;
        }
        //定义辅助数组
        int s=array.length;
        int [] tempArray=array.clone();


        //定义合并统计函数
        int count= InversePairsParion(array,tempArray,0,s-1);
        return count;
    }

    private int InversePairsParion(int[] array,int[] tempArray, int start, int end) {
        //分治极限 直到只有一个元素为止
        if(start==end){
            tempArray[start]=tempArray[end];
            return 0;
        }
        int length=(end-start)/2;
        int left=InversePairsParion(tempArray,array,start,start+length);
        int right=InversePairsParion(tempArray,array,start+length+1,end);
        int leftIndex=start+length;//前半段最后一个指针
        int rightIndex=end;//后半段最后一个指针
        int indexOfCopy=end;
        int count=0;
        //从最简单的情形  两个元素的情形起来开始调整复制 统计
        while (leftIndex>=start&&rightIndex>=start+length+1){ //防止越界  每次只在看得见的长度范围内进行调整
            if(array[leftIndex]>array[rightIndex]){
                //存在逆序对
                tempArray[indexOfCopy--]=array[leftIndex--];
                count+=rightIndex-start-length;  //需要增加的逆序对数量刚好是j里面剩下的元素数量
                if(count>=1000000007){
                    count%=1000000007;
                }
            }else {
                //不存在逆序对
                tempArray[indexOfCopy--]=array[rightIndex--];
            }
        }
        for (int i = leftIndex; i >=start; i--) {
            tempArray[indexOfCopy--]=array[i];
        }
        for (int i = rightIndex; i >=start+length+1; i--) {
            tempArray[indexOfCopy--]=array[i];
        }
        //然后更新array
        return (left+right+count)%1000000007;
    }

    public static  void main(String [] args){
        int arrs[]={364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575
        };
        int newE[]={1,2,3,4,5,6,7,0};
        int s=   new InversePairsNumber().InversePairs2(newE);
        System.out.println("vvvvv");
    }
}
