package Algorithm.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/21.
 */
public class shellSort {
    private static int count=0;
    /**
     *   对直接插入排序的改进，，
     *   分析直接插入排序算法，对于很小的一个数据，如果这个数据比较靠右边，那么
     *   为了把这个数据单元移动到左边 正确的位置，至少每个元素移动接近n个位置，
     *   平均看来 每个进行n/2个空格移动，每个进行n^2/次复制，时间复杂度为O(n^2)
     *
     *
     *   shell排序对直接插入排序进行了简单的改进，它通过加大排序的元素之间的间隔，并且
     *   在这些有间隔的元素之间进行插入排序，从而使得数据项大幅度的跃动，当这些数据项经过
     *   一趟排序之后，排序算法减小数据项之间的间隔再次进行排序，依次进行下去。其中进行这些数据
     *   项之间排序的间隔被称之为增量，习惯上用字母h来表示这个增量
     *
     *   可见直接插入排序实际上是希尔排序的特例，直接使用增量为1的shell排序就是直接插入排序
     *   从上面的算法可以得出，最终确定shell排序算法的关键在于h序列的值，常用的h序列
     *   的值，h=3*h+1--由Knuth提出，
     *   上面公式从1计算序列，反过来程序中还需要反向计算h序列。
     *   希尔排序空间开销O(1),时间开销O(n/3)
     * @param data
     */
    public static void ShellSort(DataWrap [] data){
        System.out.println("开始排序");
        int arrayLength=data.length;
        int h=1;
        while (h<=arrayLength/3){
            h=h*3+1;//按照h=h*3+1得到增量序列的最大值   ----
        }
        while (h>0){
            System.out.println("===h的值："+h+"====");
            count++;
            for(int i=h;i<arrayLength;i++){
                DataWrap temp=data[i];
                if(data[i].compareTo(data[i-h])<0){
                    int j=i-h;
                    for(;j>=0&&data[j].compareTo(temp)>0;j--){
                        data[j+h]=data[j];
                    }
                    data[j+h]=temp;
                }
                System.out.println("第"+count+"趟排序的结果为:"+ Arrays.toString(data));
            }
            h=(h-1)/3;

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
        ShellSort(data);
        System.out.println("排序后"+Arrays.toString(data));
    }
}



