package Algorithm.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/21.
 *
 *   细化而言 ，就是归并排序先将长度为n的无序序列看成是n个长度为1的有序子序列
 *   首先做两两合并，得到n/2个长度为2的有序子序列，再做两两合并，。。。。不断
 *   重复这个过程，最终得到长度为n的有序子序列
 *   长度为n的子序列只需要进行O(logn)次合并
 *
 *   步骤;
 *     1.定义变量i,i从0开始，依次等于A序列中每个元素的索引
 *     2.定义变量j,j从0开始，依次等于B序列中每个元素的索引
 *     3.拿A序列里面的i索引处的元素和B序列处j索引处的元素进行比较，将比较小的
 *     复制到一个临时的数组里面
 *     4.如果i索引处的元素小，i++,如果j索引处的元素小，j++,
 *     不断重复上述步骤，就可以将A\B两个子序列里面的元素复制到临时数组里面
 *     最后再将一个数组里面多出来的元素复制到临时数组里，合并完成。
 *
 *     分析：归并排序算法需要递归的进行合并、分解 ，每次进行一次两路归并排序需要merge一次，每次执行merge需要比较n次
 *     因此时间复杂度为:O(nlogn)
 *     归并排序空间效率很差，需要一个和原始序列长度大小的辅助序列
 *     稳定的
 */
public class MergeSort {
    //将两个有序的序列合并成为一个有序的序列
    private static void sort(DataWrap [] data,int left,int right){
        if(left<right){
            //找出中间索引
            int center=(left+right)/2;
            //对左边数据进行递归
            sort(data,left,center);
            sort(data,center+1,right);
            merge(data,left,center,right);
        }

    }

    /**
     * 将索引从left到right的数组元素进行归并排序
     *
     * @param data 数组
     * @param left  左边数组的第一个元素
     * @param center 左边数组的最后一个元素，center索引+1是右边有序数组的第一个元素的索引
     * @param right 右边数组的最后一个元素的索引
     */
    private static void merge(DataWrap[] data, int left, int center, int right) {
        DataWrap [] tempArr=new DataWrap[data.length];//临时数组
        int mid=center+1;
        int tempIndex=left;
        int temp=left;
        while (left<=center&&mid<=right){
            if(data[left].compareTo(data[mid])<=0){
                tempArr[tempIndex++]=data[left++];
            }
            else {
                tempArr[tempIndex++]=data[mid++];
            }
        }
        //将剩余的元素复制到临时数组
        while (mid<=right){
            tempArr[tempIndex++]=data[mid++];
        }
        while (left<=center){
            tempArr[tempIndex++]=data[left++];
        }
        //将合并结果复制到原来的数组
        while (temp<=right){
            data[temp]=tempArr[temp++];
        }
    }
    public static void merge_Sort(DataWrap []data){
        sort(data,0,data.length-1);
    }
    public static void main(String [] agrs){
        DataWrap [] data={
                new DataWrap(9,""),
                new DataWrap(19,""),
                new DataWrap(-9,""),
                new DataWrap(12,""),
                new DataWrap(34,""),
                new DataWrap(19,"*"),
                new DataWrap(4,""),
                new DataWrap(29,""),
                new DataWrap(59,""),
                new DataWrap(0,"")
        };
        System.out.println("排序前："+ Arrays.toString(data));
        merge_Sort(data);
        System.out.println("排序后"+Arrays.toString(data));
    }
}
