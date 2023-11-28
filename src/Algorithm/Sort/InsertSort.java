package Algorithm.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/21.
 *
 * 依次将待排序列的元素按照其关键字大小插入到前面的有序序列里面
 *   细化而言:对于一个具有n个元素的关键字序列，排序需要n-1趟插入操作
 *   第一趟：将第2个元素插入到前面的有序子序列---此时只有一个元素
 *   第二趟：将第三个元素插入到前面的有序子序列，此时前面具有2个有序子元素
 *   。。。。
 *   第n-1趟插入，将第n个元素插入到前面的有序子序列，前面的n-1位子序列是有序的
 *
 *   时间复杂度为O（n^2）
 */
public class InsertSort {
    public static void insertSort(DataWrap [] data){
        System.out.println("开始排序.....");
        int arrayLength=data.length;
        for(int i=1;i<arrayLength;i++){
            DataWrap temp=data[i];//当整体后移时候,data[i]的值不会丢失
            //如果i索引处的值比前面所有的值都大，表明已经有序，无需插入
            if(data[i].compareTo(data[i-1])<0){
                //如果当前元素比紧挨的元素小
                int j=i-1;
                //整体后移动  --直到找到比temp小的第一个元素，然后插入
                for(;j>=0&&data[j].compareTo(temp)>0;j--){
                    data[j+1]=data[j];
                }
                data[j+1]=temp;
            }
            System.out.println("第"+i+"趟排序的结果为:"+ Arrays.toString(data));
        }
    }
    public static void main(String [] args){
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
        System.out.println("排序前："+Arrays.toString(data));
        insertSort(data);
        System.out.println("排序后"+Arrays.toString(data));
    }

}
