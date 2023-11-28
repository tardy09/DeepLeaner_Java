package Algorithm.Sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/15.
 */
public class SelectSort {
    /**
     *  直接排序算法的关键就是n-1趟比较，每一趟比较的结果就是选择本趟比较最小的数据
     *  这里可以发现直接选择排序每趟最多只需要交换一次数据，只要找到本趟比较里面最小的数据然后拿他和
     *  本趟比较的第一个数据进行交换就可以了
     *  问题：每次比较，程序一旦发现某位数据比第一位的数据小，就立即交换他们，这就保证了
     *  每趟比较的所有比较过的数据中，第一位的数据永远是最小的，但是这
     *  必要，反而增加了交换的次数，导致算法的效率降低。直接选择排序是不稳定的
     * @param data
     */
    public static void selectSort(DataWrap []data){
        System.out.println("开始排序");
        int arraysLength=data.length;
        for(int j=0;j<arraysLength-1;j++){
            int minIndex=j;
            //第i个数据只需要和它后面的数据进行比较
            for(int i=j+1;i<arraysLength;i++){
                if(data[i].compareTo(data[j])>0){
                    //交换
                    DataWrap temp=data[i];
                    data[i]=data[j];
                    data[j]=temp;
                }
            }
            System.out.println("第"+j+"趟排序结束，结果是"+ Arrays.toString(data));
        }
    }
    //改善比较规则，每一趟比较完最多只会交换一次，减少不必要的交换
    /**
     *  第n趟比较至多只交换一次，永远拿n-1位的数据和中间某一项数据（本趟
     *  比较里面最小的数据）进行交换，。如果本趟比较时候第n-1位（本趟比较的第一位）
     *  数据已经是最小，那就无需要交换。
     *  直接选择排序算法效率很高，它只需要一个附加的程序单元用于进行数据交换
     *  ,其空间效率为O(1)
     * @param data
     */
    public static void selectSortStrength(DataWrap []data){
        System.out.println("开始排序");
        int arrayLength=data.length;
        for(int i=0;i<arrayLength-1;i++){
            int minIndex=i;//其中minIndex永远保留本次比较里面最小的值的Index
            for (int j=i+1;j<arrayLength;j++){
                if(data[i].compareTo(data[j])>0){
                    // 将j的值赋值给minIndex
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                //最多进行一次交换，直交换本次里面最小索引 到本趟比较的第一位，减少不必要的交换次数
                DataWrap temp=data[i];
                data[i]=data[minIndex];
                data[minIndex]=temp;
            }
            System.out.println("第"+i+"趟比较结果为:"+Arrays.toString(data));
        }
    }
}
class DataWrap implements Comparable<DataWrap>{
    int data;
    String flag;
    public DataWrap(int data, String flag) {
        this.data = data;
        this.flag = flag;
    }

    @Override
    public String toString() {

        return data+flag;
    }

    //自定义排序规则
    @Override
    public int compareTo(DataWrap o) {

        return this.data>o.data?1:(this.data==o.data?0:-1);
    }
}