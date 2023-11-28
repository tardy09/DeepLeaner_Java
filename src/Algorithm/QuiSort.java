package Algorithm;

/**
 * Created by Administrator on 2017/2/27.
 */
public class QuiSort {
    /**
     *   排序效率 为O(nlogn)
     * @param array
     */


    public static void quickSort(Integer [] array,int left,int right){
        if(left>right){
            return;
        }
        int i=left;//前置指针
        int j=right;//后置指针
        int base=array[left];//初始化初始的基准---左边
        while (i!=j) {
            while (base<=array[j]&&i<j){
                j--; //因为初始情况下 基准在左边，因此右边的先移动--每一次都确保j先走
            }
            while (base>=array[i]&&i<j){
                i++;
            }
            if (i<j) {
                swap(array,i,j);
            }
        }
        //交换基准
        array[left]=array[i];
        array[i]=base;
        quickSort(array,0,i-1);
        quickSort(array,i+1,right);
    }

    private static void swap(Integer[] array, int i, int j) {
        Integer temp;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static void main(String [] args)
    {
            Integer [] integers={2,5,1,6,66,4,7,8};
            quickSort(integers,0,7);
          for (int i = 0; i <8 ; i++) {
            System.out.print(" "+integers[i]);
        }
        System.out.println();
    }
}
