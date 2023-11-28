package Algorithm.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/16.
 * 对于一组包含有n个数据的一组记录，最坏的情况下，冒泡排序需要进行n-1次比较
 * 两两顶针形式比较交换，
 *  第二趟：第一次0和1,1和2,2和3,3和4，，，，，n-2和n-1进行比较，一次比较后最大的元素沉到了最底下
 *  第二趟：依次比较0和1,1和2，，，，，，n-3和n-2
 *
 *  ....依次类推
 *  从排序结果看 ，冒泡排序是一种稳定的排序方式，另外只需要一个稳定的附加
 *  单元用于交换，其空间效率为O(1)。
 */
public class BubbleSort {
    public static void bubbleSort(DataWrap [] data){
        System.out.println("开始排序........");
        int arrayLength=data.length;
        //总的比较次数
        for(int i=0;i<arrayLength-1;i++){
            boolean flag=false;
            for(int j=0;j<arrayLength-i-1;j++){
                if(data[j].compareTo(data[j+1])>0){
                    //交换他们
                    DataWrap temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                    flag=true;
                }
                System.out.println("第"+i+"趟的排序结果为："+ Arrays.toString(data));
                if(!flag){
                    //若这一趟没有任何交换 ，则表明已经排好序
                    break;
                }
            }
        }
    }
    public static void main(String [] args){
        DataWrap [] data={
                new DataWrap(9,""),
                new DataWrap(16,""),
                new DataWrap(21,"*"),
                new DataWrap(30,""),
                new DataWrap(49,""),
                new DataWrap(21,""),
                new DataWrap(30,"*")

        };
        System.out.println("排序前："+Arrays.toString(data));
        bubbleSort(data);
        System.out.println("排序后："+Arrays.toString(data));
    }
}
