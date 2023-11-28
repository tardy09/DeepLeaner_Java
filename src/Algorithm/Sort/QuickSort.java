package Algorithm.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/17.
 *
 *  思路：从待排的序列中任意取一个数据，如第一个数据作为分界值，所有比它小的数据元素一律放在左边
 *  ，所有比它大的元素一律放在右边，经过这一趟下来，该序列形成左右两个子序列，左边的序列都比分界值小
 *  右边的序列都比分解值大，
 *    接下来，对左右两个子序列进行递归处理，对两个子序列重新选择中心元素并按照这个规则进行调整，直到每个子表的
 *    元素只剩下一个，排序完成。
 *    算法框架分为三步：
 *       1.选择出指定的分界值----这个容易完成
 *       2.将所有的比分解值小的元素放在左边
 *       3，将所有的比分界值大的元素放在右边
 *       核心在于2,3 步
 *      a:定义一个左指针i,i变量从左边第一个索引开始，找到大于分界值的元素的索引，并且用i来记录它。
 *      b:定义一个j指针，j变量从右边第一个索引开始，找到小于分界值的元素的索引，并且用j来记录它，
 *      c:如果i<j,则交换i,j两个索引处的元素
 *      重复a,b,c三步，直到i>=j,可以判断j左边的元素都小于分界值，j右边的元素都大于分界值，最后将分界值和j索引处
 *      的元素交换就可以了。
 *   //从排序结果来看，快速排序也是一种不稳定的排序算法,因为其中包含了跳跃式交换数据
 *     快速排序的时间效率很好，因为每趟能确定的元素呈指数增长
 *     快速排序需要使用递归，而递归使用栈，因此它的空间效率为O（logn）
 */
public class QuickSort {
    private static int count=0;
    private static void swap(DataWrap [] data,int i,int j){
        DataWrap temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    private static void subSort(DataWrap [] data,int start,int end){

        if(start<end){
            DataWrap base=data[start];
            int i=start;//i从左边开始搜索，搜索大于分界值的元素的索引
            int j=end+1;//j从右边开始搜索，搜索小于分界值的元素的索引
            while (true){
                while (i<end&&data[++i].compareTo(base)<=0);
                while (j>start&&data[--j].compareTo(base)>=0);
                if(i<j){
                    swap(data,i,j);
                }
                else {
                    break;
                }
            }
            //交换分界值和j的值，一趟结束
            swap(data,start,j);
            System.out.println("第"+count+++"趟的排序结果："+Arrays.toString(data));
            subSort(data,start,j-1);//递归处理左子序列
            subSort(data,j+1,end);//递归处理右子序列
        }
    }
    public static void quickSort(DataWrap [] data){
        subSort(data,0,data.length-1);
    }
    public static void main(String [] args){
        DataWrap [] data={
                new DataWrap(9,""),
                new DataWrap(-16,""),
                new DataWrap(21,"*"),
                new DataWrap(13,""),
                new DataWrap(23,""),
                new DataWrap(30,"*"),
                new DataWrap(-49,""),
                new DataWrap(21,""),
                new DataWrap(30,""),
                new DataWrap(13,"*")
        };
        System.out.println("排序之前 ："+ Arrays.toString(data));
        quickSort(data);
        System.out.println("排序之后："+Arrays.toString(data));
    }
}
