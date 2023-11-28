package Algorithm.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/21.
 *   折半查找是对直接插入排序的简单改进，对于简单插入排序而言，当
 *   对第i-1趟需要将第i个元素插入到前面的0~n-1个元素序列中间的时候
 *   ，他总是从第i-1个元素开始进行比较，直到找到他的插入位置，很显然没有用到前面0
 *   ~i-1个元素已经排列有序这一事实，而折半查找则显然改进了这一点。
 */
public class BinaryInsertSort {

    public static void binArayInsertSort(DataWrap [] data){
        System.out.println("开始排序......");
        int arrayLength=data.length;
        for(int i=1;i<arrayLength;i++){
            DataWrap temp=data[i];
            int low=0;
            int high=i-1;
            while (low<=high){
                int mid=(low+high)/2;
                if(temp.compareTo(data[mid])>0){
                    low=mid+1;//右边找
                }
                else {
                    high=mid-1;
                }
            }
            for(int j=i;j>low;j--){
                data[j]=data[j-1];
            }
            data[low]=temp;
            System.out.println("第"+i+"趟排序结果为"+ Arrays.toString(data));
        }
    }
}
