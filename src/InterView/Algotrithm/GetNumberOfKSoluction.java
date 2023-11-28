package InterView.Algotrithm;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/26.
 */
public class GetNumberOfKSoluction {
    //统计一个数字在排序数组中出现的次数。

    public int GetNumberOfK(int [] array , int k) {
       int s=array.length;
       if(s==0){
           return 0;
       }
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int count=0;
        for (int i = 0; i <s; i++) {
            if (hashMap.containsKey(array[i])) {
                count=hashMap.get(array[i]);
                hashMap.put(array[i],++count);
            }
            else {
                hashMap.put(array[i],1);
            }
        }
        return hashMap.get(k)==null?0:hashMap.get(k);
    }

    /**
     * 借鉴二分查找的思想 进行分析
     *   对于 1,2,3,3,3,3,4,5 而言 0---7
     *   找到第一个开始的下标和最后一个开始的下标
     *
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK2(int [] array , int k){
        int s=array.length;
        if(s==0){
            return 0;
        }
        int left=0;
        int right=s-1;
        int count=0;
        if(left==right){
            if(array[0]==k){
                return 1;
            }
            else {
                return 0;
            }
        }
        while (left<right){
            int middle=(left+right)/2;
            if(array[middle]==k){
                count++;
                //然后在局部进行分析查找
                //  0  1 2  4 5  6  7
                // [1,2,3] [3,3,,4,5]
                int temp1=middle-1;
                int temp2=middle+1;
                while (temp1>=left&&array[temp1]==k){
                    count++;
                    temp1--;
                }
                while (temp2<=right&&array[temp2]==k){
                    count++;
                    temp2++;
                }
                break;
            }
            if(array[middle]<k){
                left=middle+1;
            }
            else {
                right=middle-1;
            }
        }
        return count;
    }
    public  static  void   main(String [] args){
         int arr[]={3,3,3,3,4,5};
        int res=new GetNumberOfKSoluction().GetNumberOfK2(arr,3);
        System.out.println("vvvvvvvvvv");

    }
}
