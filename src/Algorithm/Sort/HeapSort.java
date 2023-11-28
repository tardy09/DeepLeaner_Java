package Algorithm.Sort;

import java.util.Arrays;

/**
 *  Created by Administrator on 2016/11/15.
 *  n个数据k1,k2,,,,,kn-1,满足
 *  当且仅当满足一下关系，Ki<=K2i+1且Ki<=K2i+1(其中i=0,2,)---大根堆
 *  大根堆的根节点一定是这组数据中值最大的节点
 *  堆排序的关键在于建堆
 *  步骤:
 *  1.第一趟建立堆.拿堆的根节点和最后一个节点进行交换
 *  2.第二趟将索引0-n-2处的全部数据建立大顶堆，就可以选择出这组数据里面的最大值，将上一步
 *  所建立的大顶的根节点和这组数据的倒数第二个节点进行交换，就会使得这组数据中最大最小的值排在倒数
 *  第二位
 *  .....
 *  第k趟，将索引0~n-k处的全部数据建立大顶或者小顶堆，就可以选择出这组数据中最大的值
 *  将上一步所建立的大顶堆的根节点和这组数据的倒数第k个节点进行交换，使得这组数据里面最大最小的值排在倒数第k位。
 *  重复1.2 .
 *  由此可见，对于包含n个数据元素的数据组而言，堆排序需要n-1次建立堆，每次建立
 *  堆的作用就是选择出该堆的最小值和最大值，因此堆排序本质上也是一种选择排序
 *  和选择排序的不同在于，堆排序可以通过树形结构保存部分比较结果，可以减少比较次数。
 *  建堆过程：
 *  从一个非叶子节点开始，比较该节点和它的两个子节点的值，；如果某个子节点的值大于
 *  父节点的值，则把父节点和较大的子节点进行交换，向前逐步调整直到根节点，也就是‘b
 *  保证每个父亲节点的值都大于或等于其左，右子节点的值，建立堆完成，。
 *  过程步骤：
 *    1.将要进行排序的数组转化成完全二叉树
 *    2.完全二叉树的最后一个非叶子节点，也就是最后一个节点的父节点开始调整。
 *    3.向前处理前一个节点，---依次进行直到根节点
 *    另外，如果交换过程中，某个节点和它的子节点交换后，如果该子节点又有子节点，系统还需要再次
 *    对该子节点进行判断。
 */
public class HeapSort {
    /**
     *  对于堆排序算法而言，假设有n项数据，需要进行n-1次建堆，每次建堆需要耗时logn,因此时间复杂度为O(nlogn).
     * @param data
     */
    public static void heapSort(DataWrap [] data){
        System.out.println("开始排序。。。。。");
        int arrayLength=data.length;
        for(int i=0;i<arrayLength-1;i++){
            //建立堆
            buildMaxHeap(data,arrayLength-i-1);
            //交换堆顶部和最后一个元素

            swap(data,0,arrayLength-1-i);
            System.out.println("第"+i+"轮排序结果为"+ Arrays.toString(data));
        }
    }
    /**
     * 交换data数组里面i,j两个索引位置处的元素
     * @param data
     * @param i
     * @param j
     */
    private static void swap(DataWrap [] data,int i,int j){
        DataWrap temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    /**
     * 建立大根堆
     * @param data
     * @param lastIndex
     */
    private static void buildMaxHeap(DataWrap [] data,int lastIndex)
    {
        //从lastIndex的父节点（最后一个父节点）开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            int k=i;//k保存当前正在判断的节点
            //如果k节点的子节点存在--每次调整完都要看当前节点是否有子节点，看子节点经过调整后，，是否满足
            while (k*2+1<=lastIndex){
                int biggerIndex=2*k+1;//左子节点索引
                if (biggerIndex<lastIndex) {
                    biggerIndex=(data[biggerIndex].compareTo(data[biggerIndex+1]))<0?biggerIndex+1:biggerIndex;
                }
//                //如果biggerIndex小于lastIndex，即就是biggerIndex+1
//                if(biggerIndex<lastIndex){
//                    if(data[biggerIndex].compareTo(data[biggerIndex+1])<0){
//                        //左节点大于右边节点
//                       biggerIndex++;   //biggerIndex总是记录大子节点的值
//                    }
//                }
                if(data[k].compareTo(data[biggerIndex])<0){
                    swap(data,k,biggerIndex);
                    //将biggerIndex的值赋值给k,开始while循环的下次循环
                    k=biggerIndex;
                }
                else {
                    break;
                }
            }
        }
    }

    public static void main(String [] args){
        DataWrap [] data={
                new DataWrap(21,""),
                new DataWrap(30,""),
                new DataWrap(49,""),
                new DataWrap(30,"*"),
                new DataWrap(21,"*"),
                new DataWrap(16,""),
                new DataWrap(9,"")
        };
        System.out.println("排序前："+Arrays.toString(data));
        heapSort(data);
        System.out.println("排序后："+Arrays.toString(data));
    }
}
